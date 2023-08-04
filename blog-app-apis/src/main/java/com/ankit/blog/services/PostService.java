package com.ankit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ankit.blog.entities.Post;
import com.ankit.blog.payloads.PostDto;
import com.ankit.blog.payloads.PostResponse;

public interface PostService {

	 void  deletePost(Integer postId);
	 
	 Post updatePost(PostDto postDto,Integer id);
	
	 PostResponse getAllPosts(int pageNumber,int pageSize);
	 

	 PostDto getPostById(Integer postId);
	 
	 List<PostDto> getPostsByCategory(Integer categoryId);
	 
	 List<PostDto> getPostsbyUser(Integer userId);
	 
	 List<PostDto> searchPosts(String Keyword);
	 PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	 
	 
	 
	 

}
