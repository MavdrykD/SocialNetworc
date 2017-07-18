package com.social_network.controller;

import com.social_network.dto.DTOUtilMapper;
import com.social_network.dto.FriendsDTO;
import com.social_network.dto.MessageDTO;
import com.social_network.entity.Message;
import com.social_network.service.MailSenderService;
import com.social_network.validator.Validator;
import com.social_network.validator.userLoginValidation.UserLoginValidationMessages;
import com.social_network.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.social_network.entity.User;
import com.social_network.service.UserService;
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

//    @GetMapping("/failureLogin")
//    public String loginFailed(Model model) {
//        model.addAttribute("user", new User());
//        return "views-base-index";
//    }

	@GetMapping("/")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "views-base-index";
	}

	@PostMapping("/signUp")
	public String saveUser(@ModelAttribute("user") User user, Model model){
		String uuid = UUID.randomUUID().toString();
		user.setUuid(uuid);
		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMessages.EMPTY_FIRST_NAME_FIELD)){
				model.addAttribute("first_nameException", e.getMessage());
			}else if (e.getMessage().equals(UserValidationMessages.EMPTY_LAST_NAME_FIELD)){
				model.addAttribute("last_nameException", e.getMessage());
			}else if (e.getMessage().equals(UserValidationMessages.EMPTY_LOGIN_FIELD) ||
						e.getMessage().equals(UserValidationMessages.LOGIN_ALREADY_EXIST)){
				model.addAttribute("loginException", e.getMessage());
			}else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD)||
					e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)||
					e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)){
				model.addAttribute("emailException", e.getMessage());
			}

			System.out.println("user = " + user);
			return "views-base-index";
		}
		String theme = "thank's for registration";
		String mailBody =
				"gl & hf       http://localhost:8080/confirm/" + uuid;

		mailSenderService.sendMail(theme, mailBody, user.getEmail());

		return  "redirect:/";
	}

	@PostMapping("/failureLogin")
	public String failureLogin(Model model, @RequestParam String username, @RequestParam String password){
		try {
			validator.validate(new User(username,password));
		} catch (Exception e) {
			if(e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("exception", e.getMessage());
			}else if(e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)){
				model.addAttribute("exceptionPassword", e.getMessage());
			}

		}
		model.addAttribute("user", new User());

		return  "views-base-index";
	}

	@GetMapping("/confirm/{uuid}")
	public String confirm(@PathVariable String uuid) {

		User user = userService.findByUuid(uuid);
		user.setEnable(true);

		userService.update(user);

		return "redirect:/";
	}

//	@PostMapping("/addImage")
//	public String addImage(@RequestParam MultipartFile image){
//
//		return
//	}
	
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
    public String userPage(){
		return "views-user-userPage";
	}

	@PostMapping("/userPage")
	public String helloUser(Principal principal){
		int idSecuredUser = Integer.valueOf(principal.getName());
		return "views-user-userPage/"+idSecuredUser;
	}

	@GetMapping("/friends")
	public String seeAllFriends(Model model, Principal principal){
		User user = userService.findByIdWithFriends(Integer.valueOf(principal.getName()));
		model.addAttribute("friends", DTOUtilMapper.usersToFriendsDTOs(user.getFriends()) );

		return "views-user-friends";
	}

	@GetMapping("/findNewFriend")
	public String findNewFriends(Model model, Principal principal){
		model.addAttribute("users", userService.findAllWhoCanBeAddedToFriends(Integer.valueOf(principal.getName())));
		return "views-user-findFriends";
	}

	@ResponseBody
	@GetMapping("/securedUser")
	public String getSecuredUser(Principal principal){
		User user = userService.findOne(Integer.valueOf(principal.getName()));
		String securedUser = "Hi "+user.getFirstName();
		return securedUser;
	}

	@GetMapping("/allUsers")
	public String seeAllUser(Model model){
		model.addAttribute("users", userService.findAll());
		return "views-admin-allUser";
	}

	@GetMapping("/userPage/{id}")
	public String seeFriendPage(@PathVariable int id, Model model){
		model.addAttribute("user", userService.findOne(id));
		String idUser = String.valueOf(id);
		return "views-admin-friendPage";
	}



}
