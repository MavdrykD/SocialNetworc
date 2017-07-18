package com.social_network.validator.userLoginValidation;

import com.social_network.dao.UserDao;
import com.social_network.entity.User;
import com.social_network.validator.Validator;
import com.social_network.validator.userValidator.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Дімон on 13.06.2017.
 */
@Component
public class UserLoginValidator implements Validator{
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;
        if (user.getLogin().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByLogin(user.getLogin()) == null) {
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(), userDao.findByLogin(user.getLogin()).getPassword())){
            System.err.println("password Exception");
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        }
    }
}
