package com.social_network.service;

import java.util.List;

import com.social_network.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserService {
	
	
	void save(User user) throws Exception;

	List<User> findAll();

	List<User> findAllWhoCanBeAddedToFriends(int id);

	User findOne(int id);

	void delete(int id);

	void update(User user);
	
	User findByEmail(String email);

	User findByLogin(String login);

	User findByUuid(String uuid);

	User findByIdWithFriends(@Param("id") int id);

	List<User> findAllUsersByIdToWhomISentTheRequest(@Param("id") int id);

	List<User> findAllUsersByIdWhoSentMeARequest(@Param("id") int id);

	User changeFieldsUser(User user, User activeUser, String password);

}
