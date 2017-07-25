package com.social_network.controller;

import com.social_network.entity.Message;
import com.social_network.entity.User;
import com.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.social_network.service.MessageService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public String seeAllCorrespondence(Model model, Principal principal) {
        List<Message> messages = messageService.findAllMessagesForPreview(Integer.valueOf(principal.getName()));
        model.addAttribute("previewDialogues", messages);
        return "views-message-message";
    }
    @Transactional
    @ResponseBody
    @PostMapping(value = "/sendMessage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> sendMessage(@RequestBody Message message, Principal principal) {
        int idActiveUser = Integer.valueOf(principal.getName());
        message.setUserSender(userService.findOne(idActiveUser));
        message.setDateOfMessageCreation(LocalDateTime.now());
        message.setForPreview(true);
        Message lastMessage = messageService.findLastDialogue(idActiveUser, message.getUserReceiver().getId());
        if (lastMessage != null) {
            lastMessage.setForPreview(false);
            messageService.update(lastMessage);
        }
        messageService.save(message);

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");
        strings.add("seven");

//        for (Message m: messsages) {
//            System.err.println(m.getUserSender().getRole());
//        }
        return strings;
    }

    @GetMapping("/dialogue/{idSender}/{idReceiver}")
    public String seeDialogue(@PathVariable int idSender, @PathVariable int idReceiver, Model model) {
        model.addAttribute("dialogue", messageService.findOneDialogue(idSender, idReceiver));
        return "views-message-theDialogue";
    }

//	@ResponseBody
//	@PostMapping("/sendMessages")
//	public String sendMessageFromUserMessages(@RequestBody Message message, Principal principal){
//		int idActiveUser = Integer.valueOf(principal.getName());
//		message.setUserSender(userService.findOne(idActiveUser));
//		message.setDateOfMessageCreation(LocalDateTime.now());
//		message.setForPreview(true);
//		Message lastMessage = messageService.findLastDialogue(idActiveUser, message.getUserReceiver().getId());
//		if(lastMessage != null){
//			lastMessage.setForPreview(false);
//			messageService.update(lastMessage);
//		}
//		messageService.save(message);
//		return "views-message-theDialogue";
//	}


}
