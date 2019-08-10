package com.ps.userapp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("hello")
    String hello(@RequestParam String name);
}
