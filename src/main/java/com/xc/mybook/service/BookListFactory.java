package com.xc.mybook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookListFactory {
    @Autowired
    private BookListServiceCatagory bookListServiceCatagory;

    @Autowired
    private BookListServiceDate bookListServiceDate;

    @Autowired
    private BookListServiceIndex bookListServiceIndex;

    @Autowired
    private BookListServiceCatagorySub bookListServiceCatagorySub;

    public BookListService getBookListService(String bookListType){
        switch (bookListType){
            case "index":
                return bookListServiceIndex;
            case "datecata":
                return bookListServiceDate;
            case "catagory":
                return bookListServiceCatagory;
            case "catagorysub":
                return bookListServiceCatagorySub;

                default:
                    return bookListServiceIndex;
        }
    }

}
