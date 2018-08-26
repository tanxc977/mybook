package com.xc.mybook.controler;

import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.service.BookDetailService;
import com.xc.mybook.service.BookStaticsViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloTest {

    private static final Logger logger = LoggerFactory.getLogger(HelloTest.class);
    @Autowired
    private BookStaticsViewService bookStaticsViewService;

    @Autowired
    private BookDetailService bookDetailService;

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

    @RequestMapping(value = "/layout")
    public String layout(){
        return "layout";
    }

    @RequestMapping(value = "/footer")
    public String layout2(){
        return "footer";
    }

    @GetMapping(value = "/book/base")
    public String bookBase(){
        return "book/base";
    }


    @GetMapping(value ="/list")
    public String getBookList(){

        return defaultListPage(new HashMap<String,Object>(),"1");
    }


    //default list
    @RequestMapping("/defaultlist/{pageNum}")
    public String defaultListPage(Map<String,Object> map,@PathVariable("pageNum") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type","a");
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "book/defaultlist";
    }

//    @RequestMapping(value = "/login.html")
//    public String login(){
//        return "login2";
//    }

    @RequestMapping(value = "/loginerror")
    public String loginError(){
        return "loginerror";
    }
}