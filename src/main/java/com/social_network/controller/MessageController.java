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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.resources.Messages;

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
	public String seeAllCorrespondence(Model model, Principal principal){
		List<Message> messages = messageService.findAllMessagesForPreview(Integer.valueOf(principal.getName()));
		model.addAttribute("previewDialogues", messages);
		return "views-message-message";
	}

	@ResponseBody
	@PostMapping("/sendMessage")
	public void sendMessage(@RequestBody Message message, Principal principal){
		int idActiveUser = Integer.valueOf(principal.getName());
		message.setUserSender(userService.findOne(idActiveUser));
		message.setDateOfMessageCreation(LocalDateTime.now());
		message.setForPreview(true);
		Message lastMessage = messageService.findLastDialogue(idActiveUser, message.getUserReceiver().getId());
		if(lastMessage != null){
			lastMessage.setForPreview(false);
			messageService.update(lastMessage);
		}
		messageService.save(message);
	}

	@GetMapping("/dialogue/{idSender}/{idReceiver}")
	public String seeDialogue(@PathVariable int idSender, @PathVariable int idReceiver, Model model){
		model.addAttribute("dialogue", messageService.findOneDialogue(idSender, idReceiver));
		return "views-message-theDialogue";
	}
//	@ResponseBody
//	@PostMapping("/sendMessages")
//	public void sendMessageFromUserMessages(@RequestBody Message message, Principal principal){
//		int idActiveUser = Integer.valueOf(principal.getName());
//int fdsf= 1;
//		message.setUserSender(userService.findOne(idActiveUser));
//		message.setDateOfMessageCreation(LocalDateTime.now());
//		message.setForPreview(true);
//		Message lastMessage = messageService.findLastDialogue(idActiveUser, message.getUserReceiver().getId());
//		if(lastMessage != null){
//			lastMessage.setForPreview(false);
//			messageService.update(lastMessage);
//		}
//		messageService.save(message);
//	}





	
	
	
}
