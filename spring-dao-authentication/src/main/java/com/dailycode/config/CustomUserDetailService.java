package com.dailycode.config;

import com.dailycode.entity.User;
import com.dailycode.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("[CustomUserDetailService] : loadUserByUsername");
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User Not Found");
        return new CustomUserDetail(user);
    }

}
