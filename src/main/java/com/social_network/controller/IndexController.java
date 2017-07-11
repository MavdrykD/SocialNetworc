package com.social_network.controller;

import com.social_network.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

//	@GetMapping("/")
//	public String index(Model model){
//		model.addAttribute("user", new User());
//		return "views-base-index";
//	}

	@PostMapping("/")
	public String indexAfterLogIn(){
		return "views-base-index";
	}

//	@PostMapping("/file")
//	public void saveImage(MultipartFile file){
//
//		System.out.println(file.getName());
//	}
}
