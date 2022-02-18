package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Post;

public interface PostService {
	public void createPost(List<Post> post);


    public Collection<Post> getAllPosts();


    public Optional<Post> findPostById(int id);


    public void deletePostById(int id);


    public void updatePost(Post post);


    public void deleteAllPosts();


}
