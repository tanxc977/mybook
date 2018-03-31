package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.dao.BookRowMapper;
import com.xc.mybook.dao.BookStaticsRowMapper;
import com.xc.mybook.entity.Book;
import com.xc.mybook.entity.BookStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStaticsViewService {


        private static final Logger logger = LoggerFactory.getLogger(BookStaticsViewService.class);

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public List<BookStatics> getList(){
            return  jdbcTemplate.query(Constants.bookStaticsViewInquireSql, new Object[]{}, new BookStaticsRowMapper());
        }
    }

