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
import com.offreapi.offreapi.api.models.Message;
import com.offreapi.offreapi.api.repository.DiscussionRepository;
import com.offreapi.offreapi.api.repository.MessageRepository;
import com.offreapi.offreapi.api.types.CreateDiscussionRequest;
import com.offreapi.offreapi.api.types.CreateMessageRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;


@RestController
@RequestMapping("/api/service/message")
public class MessageController {
	
	 @Autowired 
	 private MessageRepository messageRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	   @PostMapping("/addMessage")
	    public Message createMessage(@RequestBody CreateMessageRequest messageRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	//System.out.println(userDetail.getEmail()+" "+userDetail.getUsername());
	    	Message message = new Message(userDetail.getId(),messageRequest.getReceiverId(), messageRequest.getSenderId(), messageRequest.getMessage());
	    	messageRepository.save(message);
	    	return message;
	    
		}
	 
	 
	 /**
	     * Method to fetch all messages from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Message> getAll() {
	        System.out.println("-------> : getAllmessages");
	        logger.debug("Getting all message.");
	        return this.messageRepository.findAll();
	    }
	    
	   
	    @GetMapping("/{id}")
	    public Optional<Message> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting users with user-id= {}.", id);
	        return this.messageRepository.findById(id);
	    }
	    
	    
	
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting discussion with id= {}.", id);
	        messageRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	 


}
