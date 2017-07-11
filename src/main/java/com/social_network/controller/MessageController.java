package com.social_network.controller;

import com.social_network.dto.DTOUtilMapper;
import com.social_network.dto.FriendsDTO;
import com.social_network.dto.MessageDTO;
import com.social_network.entity.Message;
import com.social_network.entity.User;
import com.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.social_network.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessageController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@GetMapping("/message")
	public String seeAllCorrespondence(){
		return "views-message-message";
	}
//dalete this
	@GetMapping ("/madalWindov")
	public String madalWindov(){
		return "views-message-madalWindow";
	}

	@ResponseBody
	@PostMapping("/sendMessage")
	public void sendMessage(@RequestBody Message message, Principal principal){
		message.setUserSender(userService.findOne(Integer.valueOf(principal.getName())));
		message.setDateOfMessageCreation(LocalDateTime.now());
		messageService.save(message);
	}


	
	
	
}
