package com.social_network.controller;

import com.social_network.dto.DTOUtilMapper;
import com.social_network.entity.User;
import com.social_network.service.MailSenderService;
import com.social_network.service.UserService;
import com.social_network.utility.Gender;
import com.social_network.validator.Validator;
import com.social_network.validator.userLoginValidation.UserLoginValidationMessages;
import com.social_network.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.UUID;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;
    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping("/")
    public String registration() {
        return "views-base-index";
    }

    @GetMapping("/signUp")
    public String createNewUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("gender", Gender.values());
        return "views-user-registration";
    }


    @PostMapping("/signUp")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        String userPassword = user.getPassword();
        if(user.getGender().equals(Gender.MALE)){
            user.setGender(Gender.MALE);
        }else{

            user.setGender(Gender.FEMALE);
        }
        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_FIRST_NAME_FIELD)) {
                model.addAttribute("first_nameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_LAST_NAME_FIELD)) {
                model.addAttribute("last_nameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_LOGIN_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.LOGIN_ALREADY_EXIST)) {
                model.addAttribute("loginException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST) ||
                    e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)) {
                model.addAttribute("emailException", e.getMessage());
            }
            return "views-user-registration";
        }
        String theme = "thank's for registration";
        String mailBody ="login: "+user.getLogin()+"\n"+"password: "+userPassword+"\n"+

                "gl & hf       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username, @RequestParam String password) {
        try {
            validator.validate(new User(username, password));
        } catch (Exception e) {
            if (e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)) {
                model.addAttribute("exception", e.getMessage());
//                System.err.println("Я тут");
            }
        }
        model.addAttribute("user", new User());

        return "views-base-index";
    }

    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

//	@GetMapping("/removeUser")
//	public String deleteUser(Model model){
//		model.addAttribute("users", userService.findAll());
//		return "removeUser";
//	}

//	@PostMapping("/removeUser/{id}")
//	public String deleteUser(@PathVariable int id){
//		userService.delete(id);
//		return "redirect:/removeUser";
//	}
//


    @GetMapping("/userPage")
    public String userPage() {
        return "views-user-userPage";
    }

    @PostMapping("/userPage")
    public String helloUser(Principal principal) {
        int idSecuredUser = Integer.valueOf(principal.getName());
        return "views-user-userPage/" + idSecuredUser;
    }

    @GetMapping("/friends")
    public String seeAllFriends(Model model, Principal principal) {
        User user = userService.findByIdWithFriends(Integer.valueOf(principal.getName()));
        model.addAttribute("friends", DTOUtilMapper.usersToFriendsDTOs(user.getFriends()));

        return "views-user-friends";
    }

    @GetMapping("/findNewFriend")
    public String findNewFriends(Model model, Principal principal) {
        model.addAttribute("users", userService.findAllWhoCanBeAddedToFriends(Integer.valueOf(principal.getName())));
        return "views-user-findFriends";
    }

    @ResponseBody
    @GetMapping("/activeUser")
    public String getSecuredUser(Principal principal) {
        User user = userService.findOne(Integer.valueOf(principal.getName()));
        String securedUser = user.getLogin();
        return securedUser;
    }

    @GetMapping("/allUsers")
    public String seeAllUser(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("users", userService.findAllPagesOfUsers(pageable));
        return "views-admin-allUser";
    }

    @GetMapping("/userPage/{id}")
    public String seeFriendPage(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "views-user-friendPage";
    }

    @GetMapping("/settings")
    public String changeSettings(Model model, Principal principal){
        model.addAttribute("activeUser", DTOUtilMapper.userToUserForUpdateDTO(userService.findOne(Integer.valueOf(principal.getName()))));
        return "views-user-settings";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("activeUser") User activeUser, @RequestParam String password, Model model){
        User user = userService.findOne(id);
        try {
            userService.update(userService.changeFieldsUser(user, activeUser, password));
        } catch (Exception e) {
//            if (e.getMessage().equals(UserValidationMessages.EMPTY_FIRST_NAME_FIELD)) {
//                model.addAttribute("first_nameException", e.getMessage());
//            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_LAST_NAME_FIELD)) {
//                model.addAttribute("last_nameException", e.getMessage());
//            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_LOGIN_FIELD) ||
//                    e.getMessage().equals(UserValidationMessages.LOGIN_ALREADY_EXIST)) {
//                model.addAttribute("loginException", e.getMessage());
//            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
//                model.addAttribute("passwordException", e.getMessage());
//            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD) ||
//                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST) ||
//                    e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)) {
//                model.addAttribute("emailException", e.getMessage());
//            } else  if(1==2){
//
//            }
        }
        return "redirect:/settings";
    }

    @PostMapping("/saveAvatar")
    public String saveAvatar(@RequestParam MultipartFile avatar){


        return "views-user-userPage";
    }

}
