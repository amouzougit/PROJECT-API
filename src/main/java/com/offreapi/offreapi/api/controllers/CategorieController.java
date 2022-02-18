package com.offreapi.offreapi.api.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.offreapi.offreapi.api.models.Categorie;
import com.offreapi.offreapi.api.repository.CategorieRepository;
import com.offreapi.offreapi.api.types.CreateCategorieRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/service/categorie")

public class CategorieController {

	
	 @Autowired 
	 private CategorieRepository categorieRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 
	
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Categorie> getAll() {
	        System.out.println("-------> : getAllCategories");
	        logger.debug("Getting all categorie.");
	        return this.categorieRepository.findAll();
	    }
	    
	    /**
	     * Method to fetch user by id.
	     * @param id
	     * @return
	     */
	    @GetMapping("/{id}")
	    public Optional<Categorie> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting categories with user-id= {}.", id);
	        return this.categorieRepository.findById(id);
	    }
	    
	    
	    
	    /**
	     * Method to update offre by id.
	     * @param id
	     * @param offre
	     * @return
	     */
	   /* @PutMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String update(@PathVariable(value= "id") int id, @RequestBody Offre offre) {
	        logger.debug("Updating offre with id= {}.", id);
	        offre.setId("id");
	        offreRepository.updateOffre(offre);
	        return "offre record for user-id= " + id + " updated.";
	    }
	    */
	 
	    
	    /**
	     * Method to delete user by id.
	     * @param id
	     * @return
	     */
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting categorie with id= {}.", id);
	        categorieRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	    @PostMapping("/create")
	    //@PreAuthorize("hasRole('ADMIN')")
	    public Categorie createCategorie(@Valid @RequestBody CreateCategorieRequest categorieRequest, @AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	Categorie categorie = new Categorie(categorieRequest.getTitre(), categorieRequest.getDescription());
	    	categorieRepository.save(categorie);
	    	return categorie;
	    
		}

	
}
