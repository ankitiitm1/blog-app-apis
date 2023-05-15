package com.ankit.blog.entities;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "blogTitle")
	private String blogTitle;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "imageName")
	private String img;
	
	
	private Date AddedDate;
	
	
	@JdbcTypeCode(SqlTypes.JSON)
	@ManyToOne
	private Category category;
	@JdbcTypeCode(SqlTypes.JSON)
	@ManyToOne
	private User user;
	
}
