package com.social_network.validator.userValidator;

import com.social_network.dao.UserDao;
import com.social_network.entity.User;
import com.social_network.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Дімон on 09.06.2017.
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;

        if (user.getFirstName().isEmpty()){
            throw new UserException(UserValidationMessages.EMPTY_FIRST_NAME_FIELD);
        } else if (user.getLastName().isEmpty()){
            throw  new UserException(UserValidationMessages.EMPTY_LAST_NAME_FIELD);
        } else if (user.getLogin().isEmpty()){
            throw  new UserException(UserValidationMessages.EMPTY_LOGIN_FIELD);
        } else if (userDao.findByLogin(user.getLogin()) != null){
            throw new UserException(UserValidationMessages.LOGIN_ALREADY_EXIST);
        } else if (user.getPassword().isEmpty()){
            throw new UserException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
        }else if(user.getEmail().isEmpty()){
            throw new UserException(UserValidationMessages.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")){
            throw new UserException(UserValidationMessages.WRONG_EMAIL);
        }else if(userDao.findByEmail(user.getEmail()) != null){
            throw new UserException(UserValidationMessages.EMAIL_ALREADY_EXIST);
        }
    }
}
