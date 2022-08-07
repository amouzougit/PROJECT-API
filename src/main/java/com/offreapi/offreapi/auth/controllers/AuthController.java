package com.offreapi.offreapi.auth.controllers;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.offreapi.offreapi.api.models.Offre;
import com.offreapi.offreapi.api.models.Post;
import com.offreapi.offreapi.api.types.CreateUserRequest;
import com.offreapi.offreapi.api.types.PostCreateRequest;
import com.offreapi.offreapi.api.types.UpdatePostRequest;
import com.offreapi.offreapi.api.types.UpdateUserRequest;
import com.offreapi.offreapi.auth.models.ERole;
import com.offreapi.offreapi.auth.models.Role;
import com.offreapi.offreapi.auth.models.User;

import com.offreapi.offreapi.auth.playload.request.LoginRequest;
import com.offreapi.offreapi.auth.playload.request.SignupRequest;
import com.offreapi.offreapi.auth.playload.response.ErrorResponse;
import com.offreapi.offreapi.auth.playload.response.JwtResponse;
import com.offreapi.offreapi.auth.playload.request.VerifyForgotPasswordResquest;


import com.offreapi.offreapi.auth.playload.response.MessageResponse;


import com.offreapi.offreapi.auth.repository.RoleRepository;
import com.offreapi.offreapi.auth.repository.UserRepository;
import com.offreapi.offreapi.auth.security.jwt.JwtUtils;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;
import com.offreapi.offreapi.auth.services.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
    @Autowired
	private UserService userService;
    
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		JwtResponse jwtResponse = new JwtResponse(jwt, 
				 userDetails.getId(), 											 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles);
		jwtResponse.setProfession(userDetails.getProfession());
		jwtResponse.setTelephone(userDetails.getTelephone());
		jwtResponse.setCreatedAt(userDetails.getCreatedAt());

		return ResponseEntity.ok(jwtResponse);
	}
	
	
	 @GetMapping("/getAll")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<User> getAll() {
	        System.out.println("-------> : getAllOffres");
	
	        return this.userRepository.findAll();
	    }
	    
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), signUpRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> rolesEn = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		JwtResponse jwtResponse = new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 rolesEn);
		jwtResponse.setProfession(userDetails.getProfession());
		jwtResponse.setTelephone(userDetails.getTelephone());
		jwtResponse.setCreatedAt(userDetails.getCreatedAt());
		return ResponseEntity.ok(jwtResponse);
		
	}
	
	@PostMapping("/send-forgot-password-code")
	public ResponseEntity forgotPassword(@RequestParam String email) {

		String code = userService.sendForgotPasswordCode(email);

		if(code == null) {
			
			 return ResponseEntity
			            .badRequest()
			            .body(
			                new ErrorResponse(
			                        400,
			                        "error",
			                        "error lors de l'envoie du code"
			                )

			            );
			 

		}
        return ResponseEntity
            .ok()
            .body(
               "code envoyer avec succes"
            );

	}
	
	@PostMapping("/verify-forgot-password-code")
	public ResponseEntity verifyForgotPassword(@Valid @RequestBody VerifyForgotPasswordResquest verifyForgotPasswordResquest) {

		Boolean done = userService.VerifyForgotPasswordCodeAndSetNewPassword(verifyForgotPasswordResquest.getEmail(),verifyForgotPasswordResquest.getCode(), verifyForgotPasswordResquest.getNewPassword());	
		if(done) {
		    return ResponseEntity
			.ok()
            .body(
               "mot de passe  change avec succes"
            );
			
		}
        
	  return ResponseEntity
				.badRequest()
	            .body(
	               "erreur  lors du changement  du mot de passe"
	            );
				
	}
	
	 @PostMapping("/addUser")
	    public User saveUser(@RequestBody CreateUserRequest createUserRequest,@AuthenticationPrincipal UserDetailsImpl userDetail){
	    	User user = new User();
	    	user.setEmail(createUserRequest.getEmail());
	    	user.setUsername(createUserRequest.getUsername());
	    	user.setTelephone(createUserRequest.getTelephone());
	    	user.setProfession(createUserRequest.getProfession());
	    	String passwordEncoder = encoder.encode(createUserRequest.getPassword());
	    	user.setPassword(passwordEncoder);
		 userRepository.save(user);
	        
	      return user;
	    }

	
	  @PutMapping("/updateUser")
	    public Optional<User> updateUser(@RequestBody UpdateUserRequest updateUserRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	User user = new User();
	    	if(updateUserRequest.getEmail() != null) {

	    	user.setEmail(updateUserRequest.getEmail());
	    	}
	    	
	    	if(updateUserRequest.getUsername()!= null) {

	    	user.setUsername(updateUserRequest.getUsername());
	    	}
	    	if(updateUserRequest.getPassword() != null) {
	    	
		    	String passwordEncoder = encoder.encode(updateUserRequest.getPassword());
		    	user.setPassword(passwordEncoder);
	    	}

	    	if(updateUserRequest.getTelephone() != null) {

	    	user.setTelephone(updateUserRequest.getTelephone());
	    	}
	    	if(updateUserRequest.getProfession() != null) {

	    	
	    	user.setProfession(updateUserRequest.getProfession());
	    	}
	    	user.setId(updateUserRequest.getId());
	    	userRepository.save(user);
	    	return userRepository.findById(user.getId());
	    
		}
	 
	  @DeleteMapping("/{id}/deleteUser")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity delete(@PathVariable(value= "id") String id) {
	        userRepository.deleteById(id);
	        return null;
	    }
	    
}
