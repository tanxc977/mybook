package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.dao.BookDetailRowmapper;
import com.xc.mybook.dao.BookRowMapper;
import com.xc.mybook.entity.BookDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookDetailService {

    private static final Logger logger = LoggerFactory.getLogger(BookDetailService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookListFactory bookListFactory;

    private final String sqlInquire = "select seqno,catagory_tag,update_date,book_url,book_name,book_desc,enter_date," +
            "down_url,down_pwd,image_path,file_path,download_flag,catagory_tag_main,catagory_tag_side,update_date_yyyy," +
            " update_date_mm,update_date_dd,book_star from book_detail where seqno > ? limit ?";

    public List<BookDetail> getBookListDefault(int pageNo) {
        Integer pageStartId = (int) ((pageNo - 1) * Constants.pageNum);
        return jdbcTemplate.query(sqlInquire, new Object[]{pageStartId, new Double(Constants.pageNum).intValue()},
                new BookDetailRowmapper());
    }

    public List<BookDetail> getBookListDefault2(Map<String,String> paraMapInput){
        if (!paraMapInput.containsKey("type")){
            return null;
        }
        String bookListType = paraMapInput.get("type");
        BookListService bookListService = bookListFactory.getBookListService(bookListType);
        return bookListService.getDetailList(paraMapInput);

    }

    public Integer getBookListCount(Map<String,String> mapinput){
        if(!mapinput.containsKey("type")){
            return 0;
        }
        BookListService bookListService = bookListFactory.getBookListService(mapinput.get("type"));
        return bookListService.getListCount(mapinput);
    }


}
