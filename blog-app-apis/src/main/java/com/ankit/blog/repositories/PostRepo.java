package com.ankit.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ankit.blog.entities.Category;
import com.ankit.blog.entities.Post;
import com.ankit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	//@Query("select p from Posts p where p.blogTitle like:key")
	@Query("select p from Post p where p.blogTitle like :key")
	List<Post> searchByTitle(@Param("key") String title);
	

}
