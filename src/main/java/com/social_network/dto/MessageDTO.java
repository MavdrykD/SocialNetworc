package com.social_network.dto;

import com.social_network.entity.User;

/**
 * Created by Дімон on 07.07.2017.
 */
public class MessageDTO {
    private int id;
    private int userSender;
    private String firstNameS;
    private String message;
    private int userReceiver;
    private String firstNameR;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(int userReceiver) {
        this.userReceiver = userReceiver;
    }

    public int getUserSender() {
        return userSender;
    }

    public void setUserSender(int userSender) {
        this.userSender = userSender;
    }

    public String getFirstNameS() {
        return firstNameS;
    }

    public void setFirstNameS(String firstNameS) {
        this.firstNameS = firstNameS;
    }

    public String getFirstNameR() {
        return firstNameR;
    }

    public void setFirstNameR(String firstNameR) {
        this.firstNameR = firstNameR;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", userSender=" + userSender +
                ", firstNameS='" + firstNameS + '\'' +
                ", message='" + message + '\'' +
                ", userReceiver=" + userReceiver +
                ", firstNameR='" + firstNameR + '\'' +
                '}';
    }
}
