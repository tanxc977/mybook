package com.xc.mybook.dto;

public class BookAddDto {
    private String catagoryTag;
    private String bookName;
    private String bookDesc;

    public String getCatagoryTag() {
        return catagoryTag;
    }

    public void setCatagoryTag(String catagoryTag) {
        this.catagoryTag = catagoryTag;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
