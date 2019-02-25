package com.tonny.first.dao;

public class Option {

    private Long id;
    private String sname;
    private String stype;

    public Long getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public String getStype() {
        return stype;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }
}
