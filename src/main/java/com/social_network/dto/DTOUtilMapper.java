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

    @Autowired
    private MessageService messageService;

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
}
