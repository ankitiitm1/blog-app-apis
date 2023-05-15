package com.ankit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ankit.blog.entities.Post;
import com.ankit.blog.payloads.PostDto;

public interface PostService {


	 //PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) ;
	 void  deletePost(PostDto postDto);
	 Post updatePost(PostDto postDto,Integer id);
	
	 List<Post> getAllPosts();
	 

	 Post getPostById(Integer postId);
	 
	 List<Post> getPostsByCategory(Integer categoryId);
	 
	 List<Post> getPostsbyUser(Integer userId);
	 
	 List<Post> searchPosts(String Keyword);
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	 
	 
	 
	 

}
