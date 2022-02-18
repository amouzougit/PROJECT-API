package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.offreapi.offreapi.api.models.Discussion;

@Repository
public interface DiscussionRepository extends MongoRepository<Discussion, Integer> {

}
