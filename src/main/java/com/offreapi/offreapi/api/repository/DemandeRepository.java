package com.offreapi.offreapi.api.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.offreapi.offreapi.api.models.Demande;
import com.offreapi.offreapi.auth.models.User;

@Repository
public interface DemandeRepository extends MongoRepository<Demande, Integer> {

	Collection<Demande> findByIdPost(String idPost);
	    Optional<Demande> findById(String id);
	    Optional<Demande> findByIdUser(String idUser);

	    Optional<Demande> findByIdUserAndIdPost(String idUser, String idPost);
}
