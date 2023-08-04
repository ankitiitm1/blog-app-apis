package com.ankit.blog.services.Impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ankit.blog.entities.Category;
import com.ankit.blog.entities.Post;
import com.ankit.blog.entities.User;
import com.ankit.blog.exceptions.ResourceNotFoundException;
import com.ankit.blog.payloads.ApiResponse;
import com.ankit.blog.payloads.PostDto;
import com.ankit.blog.payloads.PostResponse;
import com.ankit.blog.repositories.CategoryRepo;
import com.ankit.blog.repositories.PostRepo;
import com.ankit.blog.repositories.UserRepo;
import com.ankit.blog.services.PostService;

import jakarta.persistence.PreRemove;
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

	public void deletePost(Integer postId) {
		Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		this.postRepo.delete(post);	
	}

	@Override
	public Post updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostResponse getAllPosts(int pageNumber,int pageSize) {
		PageRequest p=PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();

        List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
		
        
        PostResponse postResponse=PostResponse.builder()
				.content(postDtos)
				.pageNumber(pagePost.getNumber())
				.pageSize(pagePost.getSize())
				.totalElements(pagePost.getTotalElements())
				.totalPages(pagePost.getTotalPages())
				.lastPage(pagePost.isLast())
				.build();
       
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post returnedPost=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		return this.modelMapper.map(returnedPost, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
		List<Post> listPosts=postRepo.findByCategory(category);
		List<PostDto> listPostsDto=listPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
			
		return listPostsDto;
	}

	@Override
	public List<PostDto> getPostsbyUser(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		List<Post> listPosts=postRepo.findByUser(user);
		List<PostDto> listPostsDto=listPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return listPostsDto;
	}

	@Override
	public List<PostDto> searchPosts(String Keyword) {
		List<Post> list=postRepo.searchByTitle("%" + Keyword + "%");
		List<PostDto> listDtos=list.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return listDtos;
	}
	
}
