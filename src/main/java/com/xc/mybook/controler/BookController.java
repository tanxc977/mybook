package com.xc.mybook.controler;

import com.xc.mybook.entity.Book;
import com.xc.mybook.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

//  每一页
    @RequestMapping(value = {"/stu/{pageNo}"})
    public List<Book> getBookList(@PathVariable("pageNo") int pageNo){
        logger.info("从数据库取数据");
        return bookService.getList(pageNo);
    }

//   主页
    @RequestMapping("/stu")
    public List<Book> getIndex(){
        return getBookList(1);
    }

//   上一页
    @RequestMapping("/stu/last/{pageNo}")
    public List<Book> getLast(@PathVariable("pageNo") int pageNo){
        return getBookList((pageNo - 1) == 0 ? 1: pageNo -1);
    }

//    下一页
    @RequestMapping("/stu/next/{pageNo}")
    public List<Book> getNext(@PathVariable("pageNo") int pageNo){
        return getBookList(pageNo + 1);
    }


}
