package com.xc.mybook.controler;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public class HelloTest {

    @RequestMapping("/hello")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from HelloTest.helloHtml");
        return "/hello";
    }


    @RequestMapping("/hello2")
    public String helloFtl(Map<String,Object> map){
        map.put("hello", "from fremarkder.hello");
        return "/hello";
    }

}