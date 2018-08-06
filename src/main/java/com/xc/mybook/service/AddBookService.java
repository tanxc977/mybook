package com.xc.mybook.service;

import com.xc.mybook.Constants;
import com.xc.mybook.Mapper.BookDetailMapper;
import com.xc.mybook.dto.BookAddDto;
import com.xc.mybook.entity.BookDetail;
import com.xc.mybook.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddBookService {

    private static final Logger logger = LoggerFactory.getLogger(AddBookService.class);
    @Autowired
    private BookDetailMapper bookDetailMapper;

    public int addBookDtl(BookAddDto bookAddDto){
        logger.info("addBookService start add ");
        BookDetail bookDetail = packBookDetail(bookAddDto);
        logger.info("addBookService finish get bookdetail entity");
        return bookDetailMapper.addNewBook(bookDetail);
    }



    private BookDetail packBookDetail(BookAddDto bookAddDto){
        BookDetail bookDetail = new BookDetail();

        String bookName;
        if(-1 != bookAddDto.getBookName().lastIndexOf(".")){
            bookName = bookAddDto.getBookName().substring(0,bookAddDto.getBookName().lastIndexOf("."));
        }else{
            bookName = bookAddDto.getBookName();
        }

        bookDetail.setBookName(bookName);
        bookDetail.setBookDesc(bookAddDto.getBookDesc());

        String tag = getCatalogTag(bookAddDto.getCatagoryTag().trim());
        bookDetail.setCatagoryTag(tag);
        String[] taglist = getTagList(tag);
        bookDetail.setCatagoryTagMain(taglist[0]);
        bookDetail.setCatagoryTagSide(taglist[1]);
        bookDetail.setUpdateDateYyyy(DateUtils.getYear());
        bookDetail.setUpdateDateMm(DateUtils.getMonth());
        bookDetail.setUpdateDateDd(DateUtils.getDay());

        bookDetail.setUpdateDate(DateUtils.getYYYYDOTMMDOTDD());
        bookDetail.setEnterDate(DateUtils.getSqlTimeStamp());

        bookDetail.setDownFlag("Y");
        bookDetail.setBookUrl("");
        bookDetail.setDownUrl("");
        bookDetail.setDownPwd("");

        //需要优化通过文件带上来文件名
        bookDetail.setFilePath(Constants.uploadFilePath2 + bookName);

        return bookDetail;
    }

    private String[] getTagList(String tagMain){
        String[] taglist = new String[]{};
        taglist = Constants.tagMap.get(tagMain).split(",");
        return taglist;
    }

    private String getCatalogTag(String tagid){
        String tag = "";
        if(!StringUtils.isNumeric(tagid)){
            return tag;
        }
        tag = Constants.tagList.get(Integer.valueOf(tagid));
        return tag;
    }

}
