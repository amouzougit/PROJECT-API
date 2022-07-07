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

import com.offreapi.offreapi.api.models.Discussion;
import com.offreapi.offreapi.api.repository.DiscussionRepository;
import com.offreapi.offreapi.api.types.CreateDiscussionRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/service/discussion")
public class DiscussionController {
	
	 @Autowired 
	 private DiscussionRepository discussionRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	    @PostMapping("/create")
	    public Discussion createDemande(@RequestBody CreateDiscussionRequest discussionRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	//System.out.println(userDetail.getEmail()+" "+userDetail.getUsername());
	    	Discussion discussion = new Discussion(userDetail.getId());
	    	discussionRepository.save(discussion);
	    	return discussion;
	    
		}
	 
	    
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/allDiscussion")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Discussion> getAll() {
	        System.out.println("-------> : getAllDiscussions");
	        logger.debug("Getting all discussions.");
	        return this.discussionRepository.findAll();
	    }
	    
	    /**
	     * Method to fetch user by id.
	     * @param id
	     * @return
	     */
	    @GetMapping("/{id}")
	    public Optional<Discussion> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting discussions with discussions-id= {}.", id);
	        return this.discussionRepository.findById(id);
	    }
	    
	    
	
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting discussion with id= {}.", id);
	        discussionRepository.deleteById(id);
	        return "discussion record for id= " + id + " deleted.";
	    }
	    

	
	

}
