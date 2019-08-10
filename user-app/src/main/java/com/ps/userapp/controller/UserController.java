package com.ps.userapp.controller;

import com.ps.userapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HelloService service;

    @GetMapping("/login")
    public String login(String name){

        return service.hello(name);
    }
}
