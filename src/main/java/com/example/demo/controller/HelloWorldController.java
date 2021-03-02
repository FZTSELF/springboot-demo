package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorldController {

    private final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    @GetMapping("log")
    public String log(){
        log.info("HelloWorldController-log-info日志");//默认
        log.debug("HelloWorldController-log-debug日志");
        log.error("HelloWorldController-log-error日志");

        return "log";
    }


    @Value("${avatarPath}")
    private String name;
    @GetMapping("index1")
    public String index1(){
        return name;
    }


    @GetMapping("index")
    public String index(){
        return "hello";
    }



}
