package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.dao.BookDetailRowmapper;
import com.xc.mybook.entity.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookListSearch extends BookListServiceAbstract {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private final String sqlInquire = Constants.commonSqlPrefix +
//            "where book_name like concat('%',?,'%') limit ?,?";
//    private final String sqlCount = "select count(*) as count from "+Constants.bookDetailTable+" where book_name like concat('%',?,'%')";

    private final String sqlInquire = Constants.commonSqlPrefix +
                "where book_name like ? limit ?,?";
    private final String sqlCount = "select count(*) as count from "+Constants.bookDetailTable+" where book_name like ?";

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
        if(!map.containsKey("searchBook")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Integer getListCount(Map<String,String> mapinput) {
        String searchBook = mapinput.get("searchBook");
        return jdbcTemplate.queryForObject(sqlCount,getQueryList(searchBook).toArray(),Integer.class);
//        return jdbcTemplate.queryForObject(sqlCount,new Object[]{searchBook},Integer.class);
    }

    @Override
    public List<BookDetail> getDetail(Map<String, String> inputPara) {
        Integer pageNo = Integer.parseInt(inputPara.get("pageNo"));
        Integer pageStartId = (int) ((pageNo - 1) * Constants.pageNum);
        String searchBook = inputPara.get("searchBook");
        List<Object> quireList = getQueryList(searchBook);
        quireList.add(pageStartId);
        quireList.add(new Double(Constants.pageNum).intValue());
        return jdbcTemplate.query(sqlInquire, quireList.toArray(),
                new BookDetailRowmapper());
//        return jdbcTemplate.query(sqlInquire, new Object[]{searchBook,pageStartId,new Double(Constants.pageNum).intValue()},
//                new BookDetailRowmapper());
    }
    private List<Object> getQueryList(String searchbook){
        List <Object> queryList=new ArrayList<>();
        queryList.add('%' + searchbook + '%');
        return queryList;
    }
}

