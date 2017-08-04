package com.social_network.validator.userValidator;

/**
 * Created by Дімон on 09.06.2017.
 */
public interface UserValidationMessages {

    String EMPTY_FIRST_NAME_FIELD = "empty first name field";

    String EMPTY_LAST_NAME_FIELD = "empty last name field";

    String EMPTY_LOGIN_FIELD = "empty login field";
    String LOGIN_ALREADY_EXIST = "login already exist";

    String EMPTY_PASSWORD_FIELD = "empty password field";

    String EMPTY_EMAIL_FIELD = "empty email field";
    String EMAIL_ALREADY_EXIST = "email already exist";
    String WRONG_EMAIL = "wrong email! need @ symbol";


}
