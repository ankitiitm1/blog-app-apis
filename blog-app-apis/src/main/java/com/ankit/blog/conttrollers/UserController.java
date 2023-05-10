package com.ankit.blog.conttrollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.blog.payloads.ApiResponse;
import com.ankit.blog.payloads.UserDto;
import com.ankit.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto=userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers(){
		List<UserDto> allUsers=this.userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);	
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
		
		UserDto updatedUser=userService.updateUser(userDto, userId);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto userDto=this.userService.getUserById(userId);
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
}
