package com.mariowesley.hr_oauth.services;

import com.mariowesley.hr_oauth.entities.User;
import com.mariowesley.hr_oauth.feignclients.UserFeignClient;
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

    public User findyEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("Email does not exist: {}", email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email does not exist: {}", email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if(user == null){
            logger.error("Email not found: {}", username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: {}", username);
        return user;
    }
}
