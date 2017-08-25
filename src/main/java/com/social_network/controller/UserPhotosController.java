package com.social_network.controller;

import com.social_network.entity.UserPhotos;
import com.social_network.service.UserPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

/**
 * Created by Дімон on 03.07.2017.
 */
@Controller
public class UserPhotosController {
    @Autowired
    private UserPhotosService userPhotosService;



    @GetMapping("/myPhotos")
    public String seeAllPhotos(Model model, Principal principal){
        model.addAttribute("userWidthImages", userPhotosService.findPhotosByUserId(Integer.valueOf(principal.getName())));
        System.err.println("photo # = "+userPhotosService.findPhotosByUserId(Integer.valueOf(principal.getName())));
        return "views-images-myPhotos";
    }

    @GetMapping("/addPhotos")
    public String addMorePhotos(){

        return "views-images-addNewPhotos";
    }

    @PostMapping("/addImage")
    public String sendPhotoToTheServer(UserPhotos userPhotos, @RequestParam("images") List<MultipartFile> images, Principal principal){
        int idUser = Integer.valueOf(principal.getName());
        userPhotosService.save(userPhotos, images, idUser);
        return "redirect:/addPhotos";
    }
}
