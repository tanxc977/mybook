package com.xc.mybook.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping("/hello2")
    public String helloFtl(Map<String,Object> map){
        map.put("hello", "from fremarkder.hello");
        return "/hello";
    }


    @RequestMapping("/index")
    public String index3Html(){
        return "/index";
    }


    @RequestMapping("/mainpagelist")
    public String mainpageHtml(){
        return "/mainpagelist";
    }

    @RequestMapping("/bookpage")
    public String bookPage(){
        return "/bookpage";
    }

    @RequestMapping("/bookpage/{type}")
    public String bookPage(@PathVariable("type") String type){
        return "/bookpage";
    }

    @RequestMapping("/bookpage/{type}/{num}")
    public String bookPage2(@PathVariable("type") String type){
        return "/bookpage2";
    }

}
