package com.ankit.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.blog.entities.Category;
import com.ankit.blog.entities.Post;
import com.ankit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> getByUser(User user);
	List<Post> getByCategory(Category category);

}