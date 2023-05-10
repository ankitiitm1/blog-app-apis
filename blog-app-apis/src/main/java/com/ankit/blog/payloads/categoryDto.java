package com.ankit.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class categoryDto {

	private Integer categoryId;
	@NotEmpty
	@Size(min = 4, message = "Minimum size of Category title is 4")
	private String categoryTitle;
	@NotEmpty
	@Size(min = 10, message = "Minimum size of Description is 10")
	private String categoryDescription;
	
	
	
}
