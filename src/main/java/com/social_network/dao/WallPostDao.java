package com.social_network.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_network.entity.Message;
import com.social_network.entity.WallPosts;

public interface WallPostDao  extends JpaRepository<WallPosts, Integer>{

}
