package com.tonny.first.dao;

import java.util.Date;

public class SMSEntity {
    private int id;
    private Date sdate;
    private String code;
    private String topho;

    public int getId() {
        return id;
    }

    public Date getSdate() {
        return sdate;
    }

    public String getCode() {
        return code;
    }

    public String getTopho() {
        return topho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTopho(String topho) {
        this.topho = topho;
    }
}
