package com.social_network.controller;

import com.social_network.entity.FriendshipOffer;
import com.social_network.entity.User;
import com.social_network.service.FriendshipOfferService;
import com.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;
import java.time.LocalDateTime;

/**
 * Created by Дімон on 27.06.2017.
 */
@Controller
public class FriendshipOfferController {

    @Autowired
    private FriendshipOfferService offerService;

    @Autowired
    private UserService userService;


    @GetMapping("/requestForFriendship/{id}")
    public String  sendRequestForFriendship(@PathVariable int id, Principal principal){
        User user = userService.findByIdWithFriends(Integer.valueOf(principal.getName()));
        User userWithOffers = userService.findOne(id);

        FriendshipOffer friendshipOffer = new FriendshipOffer(user, false, userWithOffers);

        try {
            offerService.save(friendshipOffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/findNewFriend";
    }

    @GetMapping("/allFriendRequest")
    public String seeAllFriendRequest(Model model, Principal principal){
        model.addAttribute("allFriendRequest", offerService.findUsersByIdWhoSentTheRequest(Integer.valueOf(principal.getName())));
        return "views-user-allOffers";
    }

    @GetMapping("/confirmRequest/{id}")
    public String confirmTheRequest(@PathVariable int id, Principal principal){
        FriendshipOffer friendshipOffer = offerService.findByIdAndSelectRequest(id, Integer.valueOf(principal.getName()));
        System.err.println(friendshipOffer);

        friendshipOffer.setAcceptTheOffer(true);
        friendshipOffer.setDateOfConfirmation(LocalDateTime.now());//add local date
        offerService.update(friendshipOffer);

        User user = userService.findByIdWithFriends(Integer.valueOf(principal.getName()));
        User addToFriend = userService.findByIdWithFriends(id);

        user.getFriends().add(addToFriend);
        addToFriend.getFriends().add(user);

        try {
            userService.update(user);
            userService.update(addToFriend);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/allFriendRequest";
    }

    @GetMapping("/declineRequest/{id}")
    public String declineTheRequest(@PathVariable int id, Principal principal){
        FriendshipOffer friendshipOffer = offerService.findByIdAndSelectRequest(id, Integer.valueOf(principal.getName()));
        offerService.delete(friendshipOffer.getId());
        return "redirect:/allFriendRequest";
    }

}
