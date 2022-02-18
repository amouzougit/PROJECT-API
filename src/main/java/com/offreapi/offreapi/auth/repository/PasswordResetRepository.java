package com.offreapi.offreapi.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offreapi.offreapi.auth.models.PasswordReset;

public interface PasswordResetRepository  extends MongoRepository<PasswordReset, String>{

	
	Optional<PasswordReset> findById(String id);
	
	Optional<PasswordReset> findByUserId(String userId);

  


}
