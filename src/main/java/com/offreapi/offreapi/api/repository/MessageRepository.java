package com.offreapi.offreapi.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.offreapi.offreapi.api.models.Message;

public interface MessageRepository  extends MongoRepository<Message, Integer>  {

}
