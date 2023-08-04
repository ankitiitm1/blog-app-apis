package com.ankit.blog.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ankit.blog.payloads.categoryDto;
import com.ankit.blog.payloads.UserDto;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	private String content;
	private String blogTitle;
	private String img;
	private Date addedDate;
	private categoryDto category;
	private UserDto	user;
	
}
