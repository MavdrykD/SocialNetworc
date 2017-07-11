package com.social_network.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WallPosts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_id;
	private String post;
	
	@ManyToOne
	private User user;

	public WallPosts() {
		
	}

	public WallPosts(String post) {
		super();
		this.post = post;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
