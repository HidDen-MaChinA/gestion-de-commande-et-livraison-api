package com.lazytreeapi.api.controller;

import com.lazytreeapi.api.model.user;
import com.lazytreeapi.api.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userEndpoint {
    @Autowired
    private userRepository user;

    @GetMapping("/user")
    public List<user> get(){
        return user.findAll();
    }
}
