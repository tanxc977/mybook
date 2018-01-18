package com.xc.mybook.service;

import com.xc.mybook.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sql = "select catagory_tag,book_name, enter_date from book where update_date='2018.1.7'";

    public List<Book> getList(){
        return  jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) {
                Book book = new Book();
                try{
                    book.setCatagoryTag(resultSet.getString("catagory_tag"));
                    book.setBookName(resultSet.getString("book_name"));
                    book.setEnterDate(resultSet.getTimestamp("enter_date"));
                }catch (Exception e){
                    logger.info("data base map row error" + i);
                }

                return book;
            }
        });
    }
}
