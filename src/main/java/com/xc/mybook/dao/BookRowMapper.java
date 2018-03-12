package com.xc.mybook.dao;

import com.xc.mybook.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class BookRowMapper implements RowMapper {
    private static final Logger logger = LoggerFactory.getLogger(BookRowMapper.class);

    @Override
    public Book mapRow(ResultSet resultSet, int i) {
        Book book = new Book();
        try{
            book.setSeqNo(resultSet.getInt("seqno"));
            book.setCatagoryTag(resultSet.getString("catagory_tag"));
            book.setBookName(resultSet.getString("book_name"));
            book.setEnterDate(resultSet.getTimestamp("enter_date"));
            book.setBookDesc(resultSet.getString("book_desc"));
            book.setBookUrl(resultSet.getString("book_url"));
            book.setDownFlag(resultSet.getString("download_flag"));
            book.setDownUrl(resultSet.getString("down_url"));
            book.setDownPwd(resultSet.getString("down_pwd"));
            String imagePath = resultSet.getString("image_path");

            String imageFile = imagePath.substring(imagePath.lastIndexOf("/pic"));
            book.setImagePath(imageFile);
            book.setFilePath(resultSet.getString("file_path"));
            book.setUpdateDate(resultSet.getString("update_date"));

        }catch (Exception e){
            logger.info("data base map row error" + i);
        }

        return book;
    }

}
