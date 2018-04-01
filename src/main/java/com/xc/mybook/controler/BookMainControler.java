package com.xc.mybook.controler;

import com.xc.mybook.Constants;
import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.entity.BookStatics;
import com.xc.mybook.service.BookDetailService;
import com.xc.mybook.service.BookStaticsViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookMainControler {
    /**

     * 返回html模板.

     */

    @Autowired
    BookDetailService bookDetailService;

    @Autowired
    BookStaticsViewService bookStaticsViewService;

    @RequestMapping("/index")
    public String indexHtml(){
        return "/index";
    }


    @RequestMapping("/bookindex/{type}")
    public String bookindexHtml(Map<String,Object> map,@PathVariable("type") String type){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        map.put("type",type);
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }

    @RequestMapping("/booklistpage/index")
    public String mainpageHtml2(Map<String,Object> map){

        Map<String,String> mapinput= new HashMap<>();
        mapinput.put("type","index");

        Integer totalCount = bookDetailService.getBookListCount(mapinput);

        map.put("totalCount",totalCount);
        map.put("pageNum", new Double(Constants.pageNum).intValue());
        map.put("pageNo",1);
        map.put("type","index");

        return "/booklistpage";
    }


    @RequestMapping("/booklistpage/datecata/{year}/{month}")
    public String mainpageHtml3(Map<String,Object> map, @PathVariable("year") String year, @PathVariable("month") String month){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type","datecata");
        mapinput.put("year",year);
        mapinput.put("month",month);

        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("datecata/");
        sb.append(year);
        sb.append("/");
        sb.append(month);

        map.put("type",sb.toString());

        return "/booklistpage";
    }


    @RequestMapping("/bookpage/{type}/{pageNum}")
    public String bookPage2(Map<String,Object> map,@PathVariable("type") String type,@PathVariable("pageNum") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",type);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);

        return "/bookpage2";
    }

    @RequestMapping("/bookpage/datecata/{year}/{month}/{pageno}")
    public String bookPage2(Map<String,Object> map,
                            @PathVariable("year") String year,@PathVariable("month") String month,
                            @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type","datecata");
        mapInput.put("year",year);
        mapInput.put("month",month);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }


    //---------------------
    //--以下三个 未经调试 需要再调试一下


    @RequestMapping("/bookindex/catagory/{main}")
    public String bookCatagoryHtml(Map<String,Object> map,@PathVariable("main") String main){
        List<BookStatics> bookStaticsList = bookStaticsViewService.getList();
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.listTypeCataMain);
        sb.append("/");
        sb.append(main);
        map.put("type",sb.toString());
        map.put("bookStaticsList",bookStaticsList);
        return "/bookindex";
    }


    @RequestMapping("/booklistpage/catagory/{catagoryMain}")
    public String mainpageHtml3(Map<String,Object> map, @PathVariable("catagoryMain") String catagoryMain){
        Map<String,String> mapinput= new HashMap<>();

        mapinput.put("type",Constants.listTypeCataMain);
        mapinput.put("catagoryMain",catagoryMain);

        Integer totalCount = bookDetailService.getBookListCount(mapinput);
        map.put("totalCount",totalCount);
        map.put("pageNum", new Double(Constants.pageNum).intValue());

        StringBuilder sb = new StringBuilder();
        sb.append("catagory/");
        sb.append(catagoryMain);

        map.put("type",sb.toString());

        return "/booklistpage";
    }


    @RequestMapping("/bookpage/catagory/{main}/{pageno}")
    public String bookPageCataMain(Map<String,Object> map,
                            @PathVariable("main") String main,
                            @PathVariable("pageno") String pageNo){
        Map<String,String> mapInput = new HashMap<>();
        mapInput.put("type",Constants.listTypeCataMain);
        mapInput.put("catagoryMain",main);
        mapInput.put("pageNo",pageNo);
        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
        map.put("bookDetailList",booklist);
        return "/bookpage2";
    }



//    @RequestMapping("/booklistpage")
//    public String mainpageHtml(){
//        return "/booklistpage";
//    }
//
//
//    @RequestMapping("/bookpage")
//    public String bookPage(){
//        return "/bookpage";
//    }
//
//    @RequestMapping("/bookpage/{type}")
//    public String bookPage(Map<String,Object> map,@PathVariable("type") String type){
//        Map<String,String> mapInput = new HashMap<>();
//        mapInput.put("type",type);
//        mapInput.put("pageNo","1");
//        List<BookDetail> booklist = bookDetailService.getBookListDefault2(mapInput);
//        map.put("bookDetailList",booklist);
//        return "/bookpage2";
//    }


}
