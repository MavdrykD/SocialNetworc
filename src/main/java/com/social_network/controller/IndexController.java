package com.social_network.controller;

import com.social_network.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

	@PostMapping("/")
	public String indexAfterLogIn(){
		return "views-base-index";
	}

}
