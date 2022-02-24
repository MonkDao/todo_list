package com.example.rest_api.config;

import com.example.rest_api.controller.UserController;
import com.example.rest_api.entity.Rolles;
import com.example.rest_api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class MyUserDetail implements UserDetailsService {

    @Autowired
    private UserController userController;



    private Principle getByUser(User user) {
        Set<Rolles> roles = (Set<Rolles>) user.getRolles();
        return new Principle(user.getEmail(), user.getUsername(), user.getPassword(), roles);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}