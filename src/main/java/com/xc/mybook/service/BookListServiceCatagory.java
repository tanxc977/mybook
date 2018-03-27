package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.dao.BookDetailRowmapper;
import com.xc.mybook.entity.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookListServiceCatagory extends BookListServiceAbstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sqlInquire = "select seqno,catagory_tag,update_date,book_url,book_name,book_desc,enter_date," +
            "down_url,down_pwd,image_path,file_path,download_flag,catagory_tag_main,catagory_tag_side,update_date_yyyy," +
            " update_date_mm,update_date_dd from book_detail where seqno > ? limit ? " +
            "where catagory_tag_main = ?";

    @Override
    public Boolean checkInput(Map<String, String> map) {
        if(!map.containsKey("pageNo")){
            return false;
        }
        try {
            Integer.parseInt(map.get("pageNo"));
        }catch (NumberFormatException numexp){
            return false;
        }
        if(!map.containsKey("catagory_tag_main")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<BookDetail> getDetail(Map<String, String> inputPara) {
        Integer pageNo = Integer.parseInt(inputPara.get("pageNo"));
        Integer pageStartId = (int) ((pageNo - 1) * Constants.pageNum);
        String catagoryMain = inputPara.get("catagoryMain");

        return jdbcTemplate.query(sqlInquire, new Object[]{pageStartId, new Double(Constants.pageNum).intValue(),catagoryMain},
                new BookDetailRowmapper());
    }

}
