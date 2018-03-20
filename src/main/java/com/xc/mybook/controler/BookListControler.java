package com.xc.mybook.controler;

import com.xc.mybook.entity.Book;
import com.xc.mybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class BookListControler {

    @Autowired
    private BookService bookService;

    @RequestMapping("/booklist/{pageNo}")
    public String getBookList(Map<String,Object> map, @PathVariable("pageNo") int pageNo){
        List<Book> booklist = bookService.getList(pageNo);
        map.put("booklist",booklist);
        return "/booklist";
    }

    @RequestMapping("/booklist2/{pageNo}")
    public String getBookList2(Map<String,Object> map, @PathVariable("pageNo") int pageNo){
        List<Book> booklist = bookService.getList(pageNo);
        map.put("booklist",booklist);
        return "/booklist2";
    }
}
