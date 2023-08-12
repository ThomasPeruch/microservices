package com.tperuch.hroauth.services;

import com.tperuch.hroauth.entities.UserEntity;
import com.tperuch.hroauth.feignclients.UserFeignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserEntity loadUserByUsername(String email){
        UserEntity user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("email not found: {}", email);
            throw new UsernameNotFoundException("email not found");
        }
        logger.info("email found: {}", email);
        return user;
    }
}
