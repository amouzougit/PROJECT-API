package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offreapi.offreapi.api.models.Profession;

public interface PropositionRepository extends MongoRepository<Profession, Integer> {

}
