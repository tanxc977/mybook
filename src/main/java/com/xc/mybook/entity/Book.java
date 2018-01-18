package com.xc.mybook.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
/**
 * 电子书实体类
 *
 * */

public class Book implements Serializable {
    private int seqNo;
    private String catagoryTag;
    private String updateDate;
    private String bookUrl;
    private String bookName;
    private String bookDesc;
    private Timestamp enterDate;
    private String downUrl;
    private String downPwd;
    private String imagePath;
    private String filePath;
    private String downFlag;

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getCatagoryTag() {
        return catagoryTag;
    }

    public void setCatagoryTag(String catagoryTag) {
        this.catagoryTag = catagoryTag;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
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

    public Timestamp getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getDownPwd() {
        return downPwd;
    }

    public void setDownPwd(String downPwd) {
        this.downPwd = downPwd;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDownFlag() {
        return downFlag;
    }

    public void setDownFlag(String downFlag) {
        this.downFlag = downFlag;
    }
}
