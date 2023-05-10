package com.ankit.blog.services;

import java.util.List;

import com.ankit.blog.payloads.categoryDto;

public interface CategoryService {
	
	//Create
	
	//delete
	
	//update
	

	//get
	

	
	//getall

	
	public categoryDto createCategory(categoryDto categoryDto);
	public void deleteCategory(Integer categoryId);
	public categoryDto updateCategory(categoryDto categoryDto, Integer categoryId);
	public categoryDto getCategory(Integer categoryId);
	public List<categoryDto> getAllCategory();


}
