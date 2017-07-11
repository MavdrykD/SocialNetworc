package com.social_network.service;

/**
 * Created by Дімон on 14.06.2017.
 */
public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);
}
