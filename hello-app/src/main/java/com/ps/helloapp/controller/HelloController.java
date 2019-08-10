package com.ps.helloapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger log = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> list = client.getInstances("HELLO-SERVICE");
        if (list!=null && list.size()>0){
            return list.get(0).getUri().toString();
        }
        return null;
    }

    @RequestMapping(value = "/hello")
    public String hello(String name){

        return String.format("hello %s",name);
    }
}
