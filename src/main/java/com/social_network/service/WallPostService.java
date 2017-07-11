package com.social_network.service;

import java.util.List;

import com.social_network.entity.User;
import com.social_network.entity.WallPosts;

public interface WallPostService {
	
	void save(WallPosts wallPosts);

	List<WallPosts> findAll();

	WallPosts findOne(int id);

	void delete(int id);

	void update(WallPosts wallPosts);
}
