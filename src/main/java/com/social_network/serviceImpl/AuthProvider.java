package com.social_network.serviceImpl;

import com.social_network.dao.UserDao;
import com.social_network.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Дімон on 13.06.2017.
 */
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDao userDaoimpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDaoimpl.findByLogin(authentication.getName());
        if(user==null) throw new InternalAuthenticationServiceException("not found");
        if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword()))
            throw new BadCredentialsException("wrong password");
        return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class == authentication;
    }
}
