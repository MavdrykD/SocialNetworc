package com.social_network.entity;

import javax.persistence.*;

/**
 * Created by Дімон on 14.06.2017.
 */
@Entity
public class UserPhotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String albumName;

    private String pathImage;

    @ManyToOne
    private User user;

    public UserPhotos() {
    }
//конструктор для картинок(можливо прийдеться видаляти)
    public UserPhotos(String s) {
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserPhotos{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", pathImage='" + pathImage + '\'' +
                ", user=" + user +
                '}';
    }
}
