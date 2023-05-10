package com.ankit.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min = 4,message = "Username Must be minimum of 4 length")
	private String name;
	@Email(message = "The email is not valid")
	private String email;
	@NotEmpty
	@Size(min = 4,max = 10,message = "Passsword should be greater than 4 and less than 10")
	private String password;
	private String about;
}
