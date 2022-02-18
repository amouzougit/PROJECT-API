package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Discussion;

public interface DiscussionService {
	
	public void createDiscussion(List<Discussion> discuss);


    public Collection<Discussion> getAllDiscussions();


    public Optional<Discussion> findDiscussionById(int id);


    public void deleteDiscussionById(int id);


    public void updateDiscussion(Discussion discussion);


    public void deleteAllDiscussions();


}
