package com.ankit.blog.services;

import java.util.List;

import com.ankit.blog.payloads.UserDto;

public interface UserService {
		
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userID);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

	
		
}
