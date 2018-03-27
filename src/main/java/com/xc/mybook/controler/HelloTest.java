package com.xc.mybook.controler;

import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloTest {
    /**

     * 返回html模板.

     */

    @Autowired
    BookDetailService bookDetailService;

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


    @RequestMapping("/bookindex")
    public String bookindexHtml(){
        return "/bookindex";
    }

    @RequestMapping("/booklistpage")
    public String mainpageHtml(){
        return "/booklistpage";
    }

    @RequestMapping("/booklistpage/{type}")
    public String mainpageHtml(Map<String,Object> map,@PathVariable("type") String type){
        map.put("type",type);
        return "/booklistpage";
    }

    @RequestMapping("/booklistpage/{type}/{year}/{month}")
    public String booklistPageMain(Map<String,Object> map,@PathVariable("type") String type,
                               @PathVariable("year") String year,@PathVariable("month") String month){
        map.put("type","/"+type+"/"+year+"/"+month);
        return "/booklistpage";
    }

    @RequestMapping("/bookpage")
    public String bookPage(){
        return "/bookpage";
    }

    @RequestMapping("/bookpage/{type}")
    public String bookPage(@PathVariable("type") String type){
        return "/bookpage";
    }

    @RequestMapping("/bookpage/{type}/{pageNum}")
    public String bookPage2(Map<String,Object> map,@PathVariable("type") String type,@PathVariable("pageNum") String pageNo){
        List<BookDetail> booklist = bookDetailService.getBookListDefault(Integer.parseInt(pageNo));
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }

    @RequestMapping("/bookpage/{type}/{year}/{month}/{pageno}")
    public String bookPage2(Map<String,Object> map,@PathVariable("type") String type,
                            @PathVariable("year") String year,@PathVariable("month") String month,
                            @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type","dateCatalogry");
        mapInput.put("year",year);
        mapInput.put("month",month);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }

}
