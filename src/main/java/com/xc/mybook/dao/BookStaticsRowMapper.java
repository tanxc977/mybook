package com.xc.mybook.dao;

import com.xc.mybook.entity.BookStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class BookStaticsRowMapper implements RowMapper {

    private static final Logger logger = LoggerFactory.getLogger(BookStaticsRowMapper.class);

    @Override
    public BookStatics mapRow(ResultSet resultSet, int i) {
        BookStatics bookStatics = new BookStatics();
        try{
            bookStatics.setCount(resultSet.getInt("count"));
            bookStatics.setUpdateDateMm(resultSet.getString("update_date_mm"));
            bookStatics.setUpdateDateYyyy(resultSet.getString("update_date_yyyy"));

        }catch (Exception e){
            logger.info("BookStaticsView map row error" + i);
        }

        return bookStatics;
    }

}
