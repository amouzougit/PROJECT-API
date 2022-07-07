package com.offreapi.offreapi.api.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

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

import com.offreapi.offreapi.api.models.Categorie;
import com.offreapi.offreapi.api.models.Configuration;
import com.offreapi.offreapi.api.repository.CategorieRepository;
import com.offreapi.offreapi.api.repository.ConfigurationRepository;
import com.offreapi.offreapi.api.types.CreateCategorieRequest;
import com.offreapi.offreapi.api.types.CreateConfigurationRequest;
import com.offreapi.offreapi.auth.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/service/configuration")
public class ConfigurationController {
	
	 @Autowired 
	 private ConfigurationRepository configurationRepository;
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 /**
	     * Method to fetch all users from the db.
	     * @return
	     */
	    @GetMapping("/all")
	    @ResponseStatus(HttpStatus.OK)
	    public Collection<Configuration> getAll() {
	        System.out.println("-------> : getAllConfigurations");
	        logger.debug("Getting all Configuration.");
	        return this.configurationRepository.findAll();
	    }
	    
	    /**
	     * Method to fetch user by id.
	     * @param id
	     * @return
	     */
	    @GetMapping("/{id}")
	    public Optional<Configuration> getById(@PathVariable(value= "id") int id) {
	        logger.debug("Getting Configuration with user-id= {}.", id);
	        return this.configurationRepository.findById(id);
	    }
	    
	    
	    /**
	     * Method to delete user by id.
	     * @param id
	     * @return
	     */
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public String delete(@PathVariable(value= "id") int id) {
	        logger.debug("Deleting configuration with id= {}.", id);
	        configurationRepository.deleteById(id);
	        return "offre record for id= " + id + " deleted.";
	    }
	    
	    @PostMapping("/addConfig")
	    //@PreAuthorize("hasRole('ADMIN')")
	    public Configuration createConfiguration(@Valid @RequestBody CreateConfigurationRequest configurationRequest, @AuthenticationPrincipal UserDetailsImpl userDetail) {
	    	Configuration configuration = new Configuration(configurationRequest.getId());
	    	configurationRepository.save(configuration);
	    	return configuration;
	    
		}

	

}
