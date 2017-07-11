package com.social_network.dto;

import com.social_network.entity.User;

/**
 * Created by Дімон on 07.07.2017.
 */
public class MessageDTO {
    private int id;
    private User userSender;
    private String message;
    private int userReceiver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
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

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", userSender=" + userSender +
                ", message='" + message + '\'' +
                ", userReceiver=" + userReceiver +
                '}';
    }
}
