package com.example.dockerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2017-2022
 *
 * @author: jmingXie
 * Date: 2022-09-12 0:10
 * FileName: HelloWorld
 * Description: hello world demo
 */
@RestController
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String hello(){
        return "hello world";
    }
}
