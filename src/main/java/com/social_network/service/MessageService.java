package com.social_network.service;

import java.util.List;

import com.social_network.entity.Message;
import com.social_network.entity.User;

public interface MessageService {
	
	void save(Message message);

	List<Message> findAll();

	Message findOne(int id);

	void delete(int id);

}
