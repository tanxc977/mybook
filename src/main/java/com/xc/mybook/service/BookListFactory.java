package com.xc.mybook.service;

import com.xc.mybook.Constants;
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

    @Autowired
    private BookListSearch bookListSearch;

    public BookListService getBookListService(String bookListType){
        switch (bookListType){
            case Constants.listTypeIndex:
                return bookListServiceIndex;
            case Constants.listTypeDate:
                return bookListServiceDate;
            case Constants.listTypeCataMain:
                return bookListServiceCatagory;
            case Constants.listTypeCataSub:
                return bookListServiceCatagorySub;
            case Constants.listSearch:
                return bookListSearch;

                default:
                    return bookListServiceIndex;
        }
    }

}
