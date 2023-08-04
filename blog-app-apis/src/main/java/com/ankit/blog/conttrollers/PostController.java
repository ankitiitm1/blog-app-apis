package com.ankit.blog.conttrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.blog.payloads.ApiResponse;
import com.ankit.blog.payloads.PostDto;
import com.ankit.blog.payloads.PostResponse;
import com.ankit.blog.payloads.UserDto;
import com.ankit.blog.services.PostService;
@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId){
		
		PostDto createdPost=postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/post/{postId}")
	public ResponseEntity<PostDto> getPostById(	@PathVariable Integer postId){
		
		PostDto post=postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/post")
	public ResponseEntity<PostResponse> getPost(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "3",required = false) Integer pageSize
			){
		
		PostResponse postResponse =postService.getAllPosts(pageNumber,pageSize);
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getPostByAllUser(@PathVariable Integer userId){
		
		List<PostDto> postList =postService.getPostsbyUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postList,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDto>> getPostByAllCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postList =postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postList,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
	
		this.postService.deletePost(postId);
		return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/post/{keyword}")
	public ResponseEntity<List<PostDto>> searchKeyword(@PathVariable String keyword){
		
		List<PostDto> listpostdtos=postService.searchPosts(keyword);
		
		return new ResponseEntity<List<PostDto>>(listpostdtos,HttpStatus.OK);
	}

}
