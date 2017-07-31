package com.social_network.dto;

import com.social_network.entity.Message;
import com.social_network.entity.User;
import com.social_network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дімон on 07.07.2017.
 */
public class DTOUtilMapper {

    public static FriendsDTO userToUserDTO(User user){
        FriendsDTO friendsDTO = new FriendsDTO();
        friendsDTO.setId(user.getId());
        friendsDTO.setFirstName(user.getFirstName());
        friendsDTO.setLastName(user.getLastName());
        return friendsDTO;
    }

    public static List<FriendsDTO> usersToFriendsDTOs(List<User> users){
        List<FriendsDTO> friendsDTOS = new ArrayList<>();
        for (User user: users) {
            friendsDTOS.add(userToUserDTO(user));
        }
        return friendsDTOS;
    }

    public static MessageDTO messageToMessageDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setUserReceiver(message.getUserReceiver().getId());
        messageDTO.setUserSender(message.getUserSender().getId());
        messageDTO.setMessage(message.getMessage());
        messageDTO.setFirstNameS(message.getUserSender().getFirstName());
        messageDTO.setFirstNameR(message.getUserReceiver().getFirstName());
        return messageDTO;
    }

    public static List<MessageDTO> messagesToMessagesDTO(List<Message> messages){
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message m: messages) {
            messageDTOS.add(messageToMessageDTO(m));
        }
        return messageDTOS;
    }

}
