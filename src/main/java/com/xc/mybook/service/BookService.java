package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.dao.BookRowMapper;
import com.xc.mybook.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sql = "select seqno, catagory_tag,book_name, enter_date from book where seqno > ? limit 10 ";

    private final String sqlInquire = "select seqno,catagory_tag,update_date,book_url,book_name,book_desc,enter_date," +
            "down_url,down_pwd,image_path,file_path,download_flag from book where seqno > ? limit ?";
    public List<Book> getList(int pageNo){
        Integer pageStartId = (int)((pageNo - 1) * Constants.pageNum);
        return  jdbcTemplate.query(sqlInquire, new Object[]{pageStartId, new Double(Constants.pageNum).intValue()}, new BookRowMapper());
    }

}
