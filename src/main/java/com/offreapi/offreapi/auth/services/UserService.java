package com.offreapi.offreapi.auth.services;

import java.time.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.offreapi.offreapi.auth.models.PasswordReset;
import com.offreapi.offreapi.auth.models.User;
import com.offreapi.offreapi.auth.models.UserResponse;
import com.offreapi.offreapi.auth.repository.PasswordResetRepository;
import com.offreapi.offreapi.auth.repository.UserRepository;

@Service
public class UserService {

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 10000;

	@Autowired
	private UserRepository userRepository;


    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    PasswordResetRepository passwordResetRepository;
    
    @Autowired
    private JavaMailSender javaMailSender;

	public String sendForgotPasswordCode(String email) {
		

		Optional<User> userOptional = userRepository.findByEmail(email); 
		if (!userOptional.isPresent()) {
			System.out.println("email non associer a un compte");
			return null;
		}
		
		Optional<PasswordReset> passwordResetOptional = passwordResetRepository.findByUserId(userOptional.get().getId());
		
		PasswordReset passwordReset;
		
		if (passwordResetOptional.isPresent()) {
			
			 passwordReset = passwordResetOptional.get() ;
			
			passwordReset.reset();
			
		}
		else {
			
			 passwordReset = new PasswordReset();
			
		}
 

		String code = generateDigit();
		LocalDateTime now  = LocalDateTime.now();
		String encryptedCode = encoder.encode(code);
		System.out.println("code during email sending: "+code);
		System.out.println("encrypted code during email sending: "+encryptedCode);
		
		passwordReset.setCode(encryptedCode);
		
		passwordReset.setUserId(userOptional.get().getId());
		passwordReset.setCreatedAt(now);
		
		passwordResetRepository.save(passwordReset);
		
		try {
			this.sendEmail(email, "", "code de verification du changement du  password " + code);
			return code;
			
		} catch (Exception e) {
			System.out.println(e);

			// TODO: handle exception
			return null;
		}
		

		
		
	}

	public Boolean VerifyForgotPasswordCodeAndSetNewPassword(String email, String code, String newPassword) {
		
		Optional<User> userOptional = userRepository.findByEmail(email); 
		if (!userOptional.isPresent()) {
			System.out.println("email non associer a un compte");
			return false;
		}
		String encryptedCode = encoder.encode(code);
		String userId = userOptional.get().getId();

		System.out.println("code during verification: "+code);
		System.out.println("encrypted code during verification: "+encryptedCode);
		System.out.println("userId: "+userId);
		System.out.println("validecode: "+encoder.matches(code, encryptedCode));
		

		Optional<PasswordReset> passwordResetOptional = passwordResetRepository.findByUserIdAndIsVerified(userId, false);
		if(!passwordResetOptional.isPresent()) {
			System.out.println("erreur lors de reception du password");
			return false;
		}
		System.out.println("__validecode: "+encoder.matches(code, passwordResetOptional.get().getCode()));

		if(encoder.matches(code, passwordResetOptional.get().getCode())) {
			
			User user = userOptional.get();
			user.setPassword(encoder.encode(newPassword));
			userRepository.save(user);
			PasswordReset passwordReset = passwordResetOptional.get();
			passwordReset.setVerified(true);
			passwordResetRepository.save(passwordReset);
			return true;
		}
		return false;
			
		
		
	}

	
	private PasswordReset passwordReset() {
		// TODO Auto-generated method stub
		return null;
	}

	public String resetPassword(String token, String password) {

		Optional<User> userOptional = userRepository.findByToken(token); 
		if (!userOptional.isPresent()) {
			return "token-not-valid";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "token-was-expired";

		}
		User user = userOptional.get();
		user.setPassword(
            encoder.encode(password)
        );
		user.setToken(null);
		user.setTokenCreationDate(null);

		userRepository.save(user);

		return "done";
	}
	


	/**
	 * Generate unique token. You may add multiple parameters to create a strong
	 * token.
	 * 
	 * @return unique token
	 */
	private String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}

	/**
	 * Check whether the created token expired or not.
	 * 
	 * @param tokenCreationDate
	 * @return true or false
	 */
	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);
	

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}
	
	
	public UserResponse  getRequestResponse(String userId) {
		UserResponse userResponse = new UserResponse();
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			return null;
		}
		User userObject = user.get();
		userResponse.setId(userObject.getId());
		userResponse.setEmail(userObject.getEmail());
		userResponse.setUsername(userObject.getUsername());
		return userResponse;
	}
	
	public static String generateDigit() {
		
		Random r = new Random(System.currentTimeMillis());
		
		return String.valueOf(100000+r.nextInt(200000)); 
	}
	
	 void sendEmail(String email, String subject, String message) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setFrom("kevoamouzou@gmail.com");
	        msg.setTo(email);
	        
	        msg.setSubject(subject);
	        msg.setText(message);

	        javaMailSender.send(msg);
	        

	    }
	
}