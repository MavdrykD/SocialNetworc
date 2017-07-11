package com.social_network.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_network.dao.MessageDao;
import com.social_network.entity.Message;
import com.social_network.entity.User;
import com.social_network.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDao messageDao;
	

	public void save(Message message) {
		messageDao.save(message);
	}

	public List<Message> findAll() {
		return messageDao.findAll();
	}

	public Message findOne(int id) {
		return messageDao.findOne(id);
	}

	public void delete(int id) {
		messageDao.delete(id);
	}





}
