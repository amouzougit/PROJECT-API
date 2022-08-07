package com.offreapi.offreapi.api.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import com.offreapi.offreapi.api.repository.OffreRepository;
import com.offreapi.offreapi.api.types.CreateOffreRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/service/offre")
public class OffreController {
	 @Autowired 
	 private OffreRepository offreRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Offre> getAll() {
	        System.out.println("-------> : getAllOffres");
	        logger.debug("Getting all offres.");
	        return this.offreRepository.findAll();
	    }
	    
	    /**
	     * Method to fetch user by id.
	     * @param id
	     * @return
	     */
	    @GetMapping("/{id}")
	    public Optional<Offre> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting users with user-id= {}.", id);
	        return this.offreRepository.findById(id);
	    }
	    
	  
	    
	    /**
	     * Method to delete offre by id.
	     * @param id
	     * @return
	     */
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting offre with id= {}.", id);
	        offreRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	    @PostMapping("/create")
	    public Offre createOffre(@RequestBody CreateOffreRequest offreRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	//System.out.println(userDetail.getEmail()+" "+userDetail.getUsername());
	    	Offre offre = new Offre(userDetail.getId(),offreRequest.getIdCategorie(),offreRequest.getDescription(),offreRequest.getContenu(),offreRequest.getTitre());
	    	offreRepository.save(offre);
	    	return offre;
	    
		}
	 
	
	 
	
	
	 
	

}
