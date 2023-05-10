package com.ankit.blog.services.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.blog.entities.Category;
import com.ankit.blog.exceptions.ResourceNotFoundException;
import com.ankit.blog.payloads.categoryDto;
import com.ankit.blog.repositories.CategoryRepo;
import com.ankit.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public categoryDto createCategory(categoryDto categoryDto) {
		
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCategory=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCategory, categoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		this.categoryRepo.delete(cat);
			
	}

	@Override
	public categoryDto updateCategory(categoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory=this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCategory, categoryDto.class);
	}

	@Override
	public categoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		return this.modelMapper.map(cat, categoryDto.class);
	}

	@Override
	public List<categoryDto> getAllCategory() {
		List<Category> allCategories=this.categoryRepo.findAll();
		List<categoryDto> allCategoryDtos=allCategories.stream().map((e)->this.modelMapper.map(e, categoryDto.class)).collect(Collectors.toList());
		return allCategoryDtos;
	}

}
