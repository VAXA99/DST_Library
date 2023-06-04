package com.dst_library.Config;

import com.dst_library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceConfig implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Async
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println(login);
        com.dst_library.Entity.User user = userRepository.findByLogin(login);
        if (user != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), List.of(authority));
            System.out.println(userDetails.getUsername() + ":" + userDetails.getPassword() + ". Role" + userDetails.getAuthorities());
            return userDetails;
        }
        throw new UsernameNotFoundException("User not authorized.");
    }

}
