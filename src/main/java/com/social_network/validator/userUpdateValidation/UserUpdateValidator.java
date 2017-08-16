package com.social_network.validator.userUpdateValidation;

import com.social_network.validator.Validator;

/**
 * Created by Дімон on 09.08.2017.
 */
public class UserUpdateValidator implements Validator{
    @Override
    public void validate(Object o) throws Exception {
        String LOGIN_ALREADY_EXIST = "login already exist";


        String EMAIL_ALREADY_EXIST = "email already exist";
        String WRONG_EMAIL = "wrong email! need @ symbol";
    }
}
