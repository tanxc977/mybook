package com.xc.mybook.entity;

import java.io.Serializable;

public class BookStatics implements Serializable {
    private String updateDateYyyy;
    private String updateDateMm;
    private Integer count;

    public String getUpdateDateYyyy() {
        return updateDateYyyy;
    }

    public void setUpdateDateYyyy(String updateDateYyyy) {
        this.updateDateYyyy = updateDateYyyy;
    }

    public String getUpdateDateMm() {
        return updateDateMm;
    }

    public void setUpdateDateMm(String updateDateMm) {
        this.updateDateMm = updateDateMm;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
