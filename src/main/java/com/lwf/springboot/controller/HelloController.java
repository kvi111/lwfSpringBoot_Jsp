package com.lwf.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("hello")
@Controller
public class HelloController {
    // 从 application.properties 中读取配置，如取不到默认值为Hello Angel
    @Value("${application.hello:Hello Angel}")
    private String hello;

    @RequestMapping("h")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello",hello);
        return "hello";
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String helloApi(Map<String,Object> map){
        return "hello";
    }
}
