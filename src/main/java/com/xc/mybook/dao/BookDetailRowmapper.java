package com.xc.mybook.dao;

import com.xc.mybook.Constants;
import com.xc.mybook.entity.BookDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import com.xc.mybook.utils.Config;

import java.io.File;
import java.sql.ResultSet;

public class BookDetailRowmapper implements RowMapper {
    private static final Logger logger = LoggerFactory.getLogger(BookDetailRowmapper.class);

    @Autowired
    private Config config;

    @Override
    public BookDetail mapRow(ResultSet resultSet, int i) {
        BookDetail bookDetail = new BookDetail();
        try{
            bookDetail.setSeqNo(resultSet.getInt("seqno"));
            bookDetail.setCatagoryTag(resultSet.getString("catagory_tag"));
            bookDetail.setBookName(resultSet.getString("book_name"));
            bookDetail.setEnterDate(resultSet.getTimestamp("enter_date"));
            String desc = resultSet.getString("book_desc");
            StringBuilder sbDesc = new StringBuilder();
            if(desc.length()< Constants.subContentLength){
                sbDesc.append(desc);
            }else if(desc.length() >= Constants.subContentLength){
                sbDesc.append(desc.substring(0,Constants.subContentLength));

            }
            sbDesc.append("...");
            bookDetail.setBookDesc(sbDesc.toString());

            bookDetail.setBookUrl(resultSet.getString("book_url"));
            bookDetail.setDownFlag(resultSet.getString("download_flag"));
            bookDetail.setDownUrl(resultSet.getString("down_url"));
            bookDetail.setDownPwd(resultSet.getString("down_pwd"));
            String imagePath = resultSet.getString("image_path");

            String imageFile = "";
            if(-1 != imagePath.lastIndexOf("/") && imagePath != null){
                imageFile = imagePath.substring(imagePath.lastIndexOf("/")+1);
            }
            if(-1 != imagePath.lastIndexOf("\\") && imagePath != null){
                imageFile = imagePath.substring(imagePath.lastIndexOf("\\")+1);
            }

            bookDetail.setImagePath(config.get("imagePath")+ File.separator+imageFile);

            bookDetail.setFilePath(resultSet.getString("file_path"));
            bookDetail.setUpdateDate(resultSet.getString("update_date"));
            bookDetail.setCatagoryTagMain(resultSet.getString("catagory_tag_main"));
            bookDetail.setCatagoryTagSide(resultSet.getString("catagory_tag_side"));
            bookDetail.setBookStar(resultSet.getString("book_star"));

            bookDetail.setUpdateDateMm(resultSet.getString("update_date_mm"));
            bookDetail.setUpdateDateDd(resultSet.getString("update_date_dd"));
            bookDetail.setUpdateDateYyyy(resultSet.getString("update_date_yyyy"));


        }catch (Exception e){
            logger.info("data base map row book_detail error" + i);
        }

        return bookDetail;
    }

}

