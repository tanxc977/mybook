package com.xc.mybook.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloTest {
    /**

     * 返回html模板.

     */

    @RequestMapping("/hello")
    public String helloHtml(Map<String,Object> map){

        map.put("hello","from HelloTest.helloHtml");
        return "/hello";
    }

    @RequestMapping("/index")
    public String indexHtml(){
        return "/index2";
    }

    @RequestMapping("/mainindex")
    public  String mainIndex(){
        return "/mainindex";
    }

    @RequestMapping("/hello2")
    public String helloFtl(Map<String,Object> map){
        map.put("hello", "from fremarkder.hello");
        return "/hello";
    }


}
