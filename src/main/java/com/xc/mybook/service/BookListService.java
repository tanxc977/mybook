package com.xc.mybook.service;

import com.xc.mybook.entity.BookDetail;

import java.util.List;
import java.util.Map;

public interface  BookListService {
    Boolean checkInput(Map<String,String > map);
    List<BookDetail> getDetailList(Map<String,String> inputPara);
    Integer getListCount(Map<String,String> mapInput);
}
