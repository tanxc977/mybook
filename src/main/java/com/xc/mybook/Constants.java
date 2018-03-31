package com.xc.mybook;

public class Constants {
    public static final Double pageNum = 2.00;
    public static final Integer subContentLength = 162;
    public static final String commonSqlPrefix = "select seqno,catagory_tag,update_date,book_url,book_name,book_desc," +
            "enter_date,down_url,down_pwd,image_path,file_path,download_flag,catagory_tag_main,catagory_tag_side," +
            "update_date_yyyy,update_date_mm,update_date_dd,book_star from book_detail ";
    public static final String bookDetailTable="book_detail";
    public static final String bookStaticsViewInquireSql = "select update_date_yyyy,update_date_mm,count from book_statics_view";
}
