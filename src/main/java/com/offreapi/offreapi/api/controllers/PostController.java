package com.offreapi.offreapi.api.controllers;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.offreapi.offreapi.api.models.Demande;
import com.offreapi.offreapi.api.models.Message;
import com.offreapi.offreapi.api.models.Post;
import com.offreapi.offreapi.api.repository.DemandeRepository;
import com.offreapi.offreapi.api.repository.MessageRepository;
import com.offreapi.offreapi.api.repository.PostRepository;
import com.offreapi.offreapi.api.types.CreateMessageRequest;
import com.offreapi.offreapi.api.types.PostCreateRequest;
import com.offreapi.offreapi.api.types.UpdatePostRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostController {
	
	 @Autowired 
	 private PostRepository postRepository;
	 
	 @Autowired 
	 private DemandeRepository demandeRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	    @GetMapping("/getAll")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Post> getAll() {
	        System.out.println("-------> : getAllOffres");
	        List<Post> posts = this.postRepository.findAll();
	       for (int i = 0; i < posts.size(); i++) {
	    	   Post post = posts.get(i);
	    	   post.setDemandes((List<Demande>) demandeRepository.findByIdPost(post.getId()));
		}
	       return posts;
	    }
	    
	   
	    @GetMapping("/{id}")
	    public Optional<Post> getById(@PathVariable(value= "id") String id) {
	        logger.debug("Getting users with user-id= {}.", id);
	        return this.postRepository.findById(id);
	    }
	    
	    
	    @DeleteMapping("/{id}/delete")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity delete(@PathVariable(value= "id") String id) {
	        logger.debug("Deleting discussion with id= {}.", id);
	        postRepository.deleteById(id);
	        return null;
	    }
	    
	    @PostMapping("/create")
	    public Post createPost(@RequestBody PostCreateRequest postCreateRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	Post post = new Post(userDetail.getId(), postCreateRequest.getDescription(), postCreateRequest.getTitre());
	    	if(postCreateRequest.getIdCategorie() != null) {
	    		post.setIdCategorie(postCreateRequest.getIdCategorie());
	    	}
	    	postRepository.save(post);
	    	return post;
	    
		}
	    
	    @PutMapping("/update")
	    public Post updatePost(@RequestBody UpdatePostRequest updatePosRequest,@AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	Post post = new Post(userDetail.getId(), updatePosRequest.getDescription(), updatePosRequest.getTitre());
	    	if(updatePosRequest.getIdCategorie() != null) {
	    		post.setIdCategorie(updatePosRequest.getIdCategorie());
	    	}
	    	post.setId(updatePosRequest.getId());
	    	postRepository.save(post);
	    	return post;
	    
		}
	    
		   
	    @GetMapping("/{id}/demandes")
	    public Collection<Demande> getPostDemandes(@PathVariable(value= "id") String id) {
	        return this.demandeRepository.findByIdPost(id);
	    }
	    
	    
	   
	    

}
