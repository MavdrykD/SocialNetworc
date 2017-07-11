package com.social_network.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaVendorAdapter;

import com.social_network.entity.Message;

public interface MessageDao extends JpaRepository<Message, Integer>{
	
}
