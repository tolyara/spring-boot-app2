package com.springboot.app2.service.jwt;

import com.springboot.app2.entity.jwt.User;
import com.springboot.app2.logger.AbstractLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//public class JwtUserDetailsService extends AbstractLogger implements UserDetailsService {
public class JwtUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    /*
┌─────┐
|  jwtTokenProvider defined in file spring-boot-app2\target\classes\com\springboot\app2\service\jwt\JwtTokenProvider.class]
↑     ↓
|  jwtUserDetailsService defined in file spring-boot-app2\target\classes\com\springboot\app2\service\jwt\JwtUserDetailsService.class]
↑     ↓
|  userServiceImpl defined in file spring-boot-app2\target\classes\com\springboot\app2\service\jwt\UserServiceImpl.class]
└─────┘
     */

    @Autowired
    public JwtUserDetailsService(@Lazy UserService userService) {
//        super(JwtUserDetailsService.class);
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        logger.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }

}
