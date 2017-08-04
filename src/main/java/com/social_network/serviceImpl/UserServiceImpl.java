package com.social_network.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.social_network.dao.FriendshipOfferDao;
import com.social_network.entity.FriendshipOffer;
import com.social_network.utility.Role;
import com.social_network.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.social_network.dao.UserDao;
import com.social_network.entity.User;
import com.social_network.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.AttributeConverter;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private FriendshipOfferDao offerDao;

//	public int save(User user) {
//		return userDao.saveAndFlush(user).getUser_id();
//	}


	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.save(user);
	}

	public User changeFieldsUser(User user, User activeUser, String password){
		if(!activeUser.getFirstName().isEmpty() && activeUser.getFirstName() != user.getFirstName()){
			user.setFirstName(activeUser.getFirstName());
		}
		if(!activeUser.getLastName().isEmpty() && activeUser.getFirstName() != user.getLastName()){
			user.setLastName(activeUser.getLastName());
		}
		if(!activeUser.getLogin().isEmpty() && activeUser.getLogin() != user.getLogin()){
			user.setLogin(activeUser.getLogin());
		}
		if(activeUser.getBirthday() != null && activeUser.getBirthday() != user.getBirthday()){
			user.setBirthday(activeUser.getBirthday());
		}
		if(!password.isEmpty() && !encoder.matches(password, user.getPassword())){
			user.setPassword(activeUser.getPassword());
		}
		return user;
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userDao.findByLogin(s);
	}

	@Override
	public User findByIdWithFriends(int id) {
		return userDao.findByIdWithFriends(id);
	}

	@Override
	public List<User> findAllWhoCanBeAddedToFriends(int id) {
		List<User> users = userDao.findAll();

		users.removeAll(findByIdWithFriends(id).getFriends());
		users.remove(userDao.findOne(id));
		users.removeAll(findAllUsersByIdToWhomISentTheRequest(id));
		users.removeAll(findAllUsersByIdWhoSentMeARequest(id));
		return users;
	}

	@Override
	public List<User> findAllUsersByIdToWhomISentTheRequest(int id) {
		List<User> users = new ArrayList<>();
		for (FriendshipOffer friendshipOffer : offerDao.findAllUsersByIdToWhomISentTheRequest(id)){
			users.add(friendshipOffer.getFriend());
		}
		return users;
	}

	@Override
	public List<User> findAllUsersByIdWhoSentMeARequest(int id) {
		List<User> users = new ArrayList<>();
		for (FriendshipOffer friendshipOffer : offerDao.findAllUsersByIdWhoSentMeARequest(id)){
			users.add(friendshipOffer.getUser());
		}
		return users;
	}

}
