package com.offreapi.offreapi.api.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.offreapi.offreapi.api.models.Demande;
import com.offreapi.offreapi.auth.models.User;

@Repository
public interface DemandeRepository extends MongoRepository<Demande, Integer> {

	Collection<Demande> findByIdPost(String idPost);
	    Optional<Demande> findById(String id);
	    Optional<Demande> findByIdUser(String idUser);
	  
	    Optional<Demande> findByIdUserAndIdPost(String idUser, String idPost);

//        @Query("{idUser: ?0, idPost: ?1}")                            // SQL Equivalent : SELECT * FROM BOOK where author = ? and cost=?
//        List<Demande> findByIdUserAndIdPost(String  idUser, String  idPost );

	    

}
