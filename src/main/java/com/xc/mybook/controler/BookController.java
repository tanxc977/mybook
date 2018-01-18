package com.xc.mybook.controler;

import com.xc.mybook.entity.Book;
import com.xc.mybook.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping("/stu")
    public List<Book> getBookList(){
        logger.info("从数据库取数据");
        return bookService.getList();
    }
}
