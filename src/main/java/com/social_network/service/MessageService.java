package com.social_network.service;

import java.util.List;

import com.social_network.entity.Message;
import com.social_network.entity.User;
import org.springframework.data.repository.query.Param;

public interface MessageService {
	
	void save(Message message);

	List<Message> findAll();

	Message findOne(int id);

	void delete(int id);

	void update(Message message);

	List<Message> findAllMessagesForPreview(int id);

	Message findLastDialogue(int idSender, int idReceiver);
	List<Message> findOneDialogue(int idSender, int idReceiver);
}
