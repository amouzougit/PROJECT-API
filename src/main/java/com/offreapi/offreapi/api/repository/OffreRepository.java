package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offreapi.offreapi.api.models.Offre;

public interface OffreRepository extends MongoRepository<Offre, Integer> {

}
