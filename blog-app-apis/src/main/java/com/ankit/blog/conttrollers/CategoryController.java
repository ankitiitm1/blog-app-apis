package com.ankit.blog.conttrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.blog.payloads.ApiResponse;
import com.ankit.blog.payloads.categoryDto;
import com.ankit.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/api/categories")
	public ResponseEntity<categoryDto> createCategory(@Valid @RequestBody categoryDto categoryDto){
		categoryDto createCategory=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<categoryDto>(createCategory,HttpStatus.OK);
	}

	@GetMapping("/api/categories")
	public ResponseEntity<List<categoryDto>> getAllCategory(){
		List<categoryDto> allCategories=this.categoryService.getAllCategory();
		return new ResponseEntity<>(allCategories,HttpStatus.OK);
	}
	
	
	@GetMapping("/api/categories/{CategoryId}")
	public ResponseEntity<categoryDto> getCategory(@PathVariable Integer CategoryId){
		categoryDto Category=this.categoryService.getCategory(CategoryId);
		return new ResponseEntity<categoryDto>(Category,HttpStatus.OK);
		}
	
	@PutMapping("/api/categories/{CategoryId}")
	public ResponseEntity<categoryDto> updateCategory(@Valid @RequestBody categoryDto categoryDto, @PathVariable Integer CategoryId){
		categoryDto updatedCategory=this.categoryService.updateCategory(categoryDto, CategoryId);
		return new ResponseEntity<categoryDto>(updatedCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/api/categories/{CategoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer CategoryId){
		this.categoryService.deleteCategory(CategoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true),HttpStatus.OK);
		}
}
