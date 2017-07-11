package com.social_network.service;

import com.social_network.entity.UserPhotos;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Дімон on 10.07.2017.
 */
public interface UserPhotosService {



    void save(UserPhotos userPhotos, List<MultipartFile> images, int idUser);

    List<UserPhotos> findAll();

    UserPhotos findOne(int id);

    void delete(int id);
}
