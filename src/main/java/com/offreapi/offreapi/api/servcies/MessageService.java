package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Message;

public interface MessageService {

	  public void createMessage(List<Message> message);


	    public Collection<Message> getAllMessages();


	    public Optional<Message> findMessageById(int id);


	    public void deleteMessageById(int id);


	    public void updateMessage(Message message);


	    public void deleteAllMessages();

}
