package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.offreapi.offreapi.api.models.Profession;

@Repository
public interface ProfessionRepository extends MongoRepository<Profession, Integer>  {

}
