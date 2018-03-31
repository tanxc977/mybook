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
public class BookListServiceDate extends BookListServiceAbstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sqlInquire = Constants.commonSqlPrefix +
            "where update_date_yyyy = ? and update_date_mm = ? limit ?,? ";
    private final String sqlCount = "select count(*) as count from "+Constants.bookDetailTable+" where update_date_yyyy = ? and update_date_mm = ?";
    @Override
    public Boolean checkInput(Map<String, String> map) {
        if(!map.containsKey("pageNo") || !map.containsKey("year") || !map.containsKey("month")){
            return false;
        }
        try {
            Integer.parseInt(map.get("pageNo"));
            Integer.parseInt(map.get("year"));
            Integer.parseInt(map.get("month"));
        }catch (NumberFormatException numexp){
            return false;
        }
        return true;
    }

    @Override
    public Integer getListCount(Map<String,String > mapinput) {
        String year = mapinput.get("year");
        String month = mapinput.get("month");
        return jdbcTemplate.queryForObject(sqlCount,new Object[]{year,month},Integer.class);
    }

    @Override
    public List<BookDetail> getDetail(Map<String, String> inputPara) {
        Integer pageNo = Integer.parseInt(inputPara.get("pageNo"));
        Integer pageStartId = (int) ((pageNo - 1) * Constants.pageNum);
//        Integer pageStartId = (int) (pageNo - 1);
        String year = inputPara.get("year");
        String month = inputPara.get("month");
        return jdbcTemplate.query(sqlInquire, new Object[]{year,month,pageStartId,new Double(Constants.pageNum).intValue()},
                new BookDetailRowmapper());
    }
}
