package com.social_network.validator.userValidator;

/**
 * Created by Дімон on 09.06.2017.
 */
public interface UserValidationMessages {

    String EMPTY_FIRST_NAME_FIELD = "EMPTY FIRST NAME FIELD";

    String EMPTY_LAST_NAME_FIELD = "EMPTY LAST NAME FIELD";

    String EMPTY_LOGIN_FIELD = "EMPTY LOGIN FIELD";
    String LOGIN_ALREADY_EXIST = "LOGIN ALREADY EXIST";

    String EMPTY_PASSWORD_FIELD = "EMPTY PASSWORD FIELD";
    String TOO_SHORT_PASSWORD = "TOO SHORT PASSWORD";//дописати в userValidator
    //дописати новий інпут на підтвердження пароля і обробити тут

    String EMPTY_EMAIL_FIELD = "EMPTY EMAIL FIELD";
    String EMAIL_ALREADY_EXIST = "EMAIL ALREADY EXIST";
    String WRONG_EMAIL = "WRONG_EMAIL! NEED @ SYMBOL";


}
