package com.xc.mybook.service;

import com.xc.mybook.entity.BookDetail;

import java.util.List;
import java.util.Map;

public abstract class BookListServiceAbstract implements BookListService {

    @Override
    public abstract Boolean checkInput(Map<String, String> map);

    @Override
    public List<BookDetail> getDetailList(Map<String, String> inputPara) {
        if(!checkInput(inputPara))
            return null;
        return getDetail(inputPara);
    }

    public abstract List<BookDetail> getDetail(Map<String,String> inputPara);
}
