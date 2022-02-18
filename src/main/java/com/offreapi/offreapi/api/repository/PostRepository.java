package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offreapi.offreapi.api.models.Post;

public interface PostRepository extends MongoRepository<Post, Integer>  {

}
