package com.social_network.serviceImpl;

import com.social_network.dao.UserDao;
import com.social_network.dao.UserPhotosDao;
import com.social_network.entity.User;
import com.social_network.entity.UserPhotos;
import com.social_network.service.UserPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дімон on 10.07.2017.
 */
@Service
public class UserPhotosServiceImpl implements UserPhotosService{

    @Autowired
    private UserPhotosDao userPhotosDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void save(UserPhotos userPhotos, List<MultipartFile> images, int idUser) {
        User user = userDao.findOne(idUser);

        for (MultipartFile multipartFile : images) {

            String path = "D:\\Мавдрик\\apache-tomcat-8.0.43\\resources\\"
                    + user.getLogin() + "\\" + multipartFile.getOriginalFilename();
            UserPhotos userPhotosToDB = new UserPhotos();

            userPhotosDao.saveAndFlush(userPhotosToDB);

            userPhotosToDB.setUser(user);
            userPhotosToDB.setPathImage("resources/" + user.getLogin() + "/" + multipartFile.getOriginalFilename());

            File filePath = new File(path);

            if(!filePath.exists()){
                filePath.mkdirs();
            }

            try {
                multipartFile.transferTo(filePath);
            } catch (IOException e) {
                System.out.println("error with file");
            }

            userPhotosDao.save(userPhotosToDB);
        }

    }

    @Override
    public List<UserPhotos> findAll() {
        return userPhotosDao.findAll();
    }

    @Override
    public UserPhotos findOne(int id) {
        return userPhotosDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        userPhotosDao.delete(id);
    }

    @Override
    public List<UserPhotos> findPhotosByUserId(int id) {
        return userPhotosDao.findPhotosByUserId(id);
    }
}
