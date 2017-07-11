package com.social_network.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_network.entity.Message;
import com.social_network.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao  extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	User findByLogin(String login);
//	User findByLoginOrEmail(String login);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);

	@Query("select u from User u left join fetch u.friends where u.id =:id")
	User findByIdWithFriends(@Param("id") int id);

//	@Query("select u from User u left join fetch u.receivedOffers where u.id =:id")
//	User findByIdWithreceivedOffers(@Param("id") int id);




}
