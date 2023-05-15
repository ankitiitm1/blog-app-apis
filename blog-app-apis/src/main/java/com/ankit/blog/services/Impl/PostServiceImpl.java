package com.ankit.blog.services.Impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.blog.entities.Category;
import com.ankit.blog.entities.Post;
import com.ankit.blog.entities.User;
import com.ankit.blog.exceptions.ResourceNotFoundException;
import com.ankit.blog.payloads.PostDto;
import com.ankit.blog.repositories.CategoryRepo;
import com.ankit.blog.repositories.PostRepo;
import com.ankit.blog.repositories.UserRepo;
import com.ankit.blog.services.PostService;
@Service
public class PostServiceImpl implements PostService {
	@Autowired(required = true)
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryid) {
		Post post=this.modelMapper.map(postDto,Post.class);
	
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		Category category=this.categoryRepo.findById(categoryid).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryid));
		post.setAddedDate(new Date());
		post.setImg("default.png");
		post.setUser(user);
		post.setCategory(category);
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost,PostDto.class);
	}

	@Override
	public void deletePost(PostDto postDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsbyUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String Keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
