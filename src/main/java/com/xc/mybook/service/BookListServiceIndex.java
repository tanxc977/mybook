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
public class BookListServiceIndex extends BookListServiceAbstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sqlInquire = Constants.commonSqlPrefix +" order by enter_date desc "+" limit ? , ?";
    private final String sqlCount = "select count(*) as count from "+ Constants.bookDetailTable;
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
        return true;
    }

    @Override
    public Integer getListCount(Map<String,String> map) {
        return jdbcTemplate.queryForObject(sqlCount,Integer.class);
    }

    @Override
    public List<BookDetail> getDetail(Map<String, String> inputPara) {
        Integer pageNo = Integer.parseInt(inputPara.get("pageNo"));
        Integer pageStartId = (int) ((pageNo - 1) * Constants.pageNum);
        return jdbcTemplate.query(sqlInquire, new Object[]{pageStartId, new Double(Constants.pageNum).intValue()},
                new BookDetailRowmapper());
    }
}
