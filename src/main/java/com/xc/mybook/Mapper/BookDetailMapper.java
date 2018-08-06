package com.xc.mybook.Mapper;

import com.xc.mybook.entity.BookDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDetailMapper {
    int addNewBook(BookDetail bookDetail);

}
