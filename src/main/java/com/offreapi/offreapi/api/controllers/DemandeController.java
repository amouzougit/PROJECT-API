package com.offreapi.offreapi.api.controllers;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.offreapi.offreapi.api.models.Demande;
import com.offreapi.offreapi.api.repository.DemandeRepository;
import com.offreapi.offreapi.api.types.CreateDemandeRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;



//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/service/demande")
public class DemandeController {
	
	
	 @Autowired 
	 private DemandeRepository demandeRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Demande> getAll() {
	        System.out.println("-------> : getAllOffres");
	        logger.debug("Getting all offres.");
	        return this.demandeRepository.findAll();
	    }
	    
	    /**
	     * Method to fetch user by id.
	     * @param id
	     * @return
	     */
	    @GetMapping("/{id}")
	    public Optional<Demande> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting users with user-id= {}.", id);
	        return this.demandeRepository.findById(id);
	    }
	    
	    
	
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting demande with id= {}.", id);
	        demandeRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	    @PostMapping("/create")
	    public Demande createDemande(@RequestBody CreateDemandeRequest demandeRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	//System.out.println(userDetail.getEmail()+" "+userDetail.getUsername());
	    	Demande demande = new Demande(userDetail.getId(),demandeRequest.getIdCategorie(),demandeRequest.getDescription());
	    	demandeRepository.save(demande);
	    	return demande;
	    
		}
	 
	
	 
	
	

}
