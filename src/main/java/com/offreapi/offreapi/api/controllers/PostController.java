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

import com.offreapi.offreapi.api.models.Message;
import com.offreapi.offreapi.api.models.Post;
import com.offreapi.offreapi.api.repository.MessageRepository;
import com.offreapi.offreapi.api.repository.PostRepository;
import com.offreapi.offreapi.api.types.CreateMessageRequest;
import com.offreapi.offreapi.api.types.PostCreateRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

@RequestMapping("/api/post")
public class PostController {
	
	 @Autowired 
	 private PostRepository postRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Post> getAll() {
	        System.out.println("-------> : getAllOffres");
	        logger.debug("Getting all discussions.");
	        return this.postRepository.findAll();
	    }
	    
	   
	    @GetMapping("/{id}")
	    public Optional<Post> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting users with user-id= {}.", id);
	        return this.postRepository.findById(id);
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting discussion with id= {}.", id);
	        postRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	    @PostMapping("/create")
	    public Post createPost(@RequestBody PostCreateRequest postCreateRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	//System.out.println(userDetail.getEmail()+" "+userDetail.getUsername());
	    	Post post = new Post(userDetail.getId(), postCreateRequest.getDescription());
	    	postRepository.save(post);
	    	return post;
	    
		}

}
