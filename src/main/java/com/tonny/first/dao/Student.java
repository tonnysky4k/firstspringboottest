package com.tonny.first.dao;

import java.io.Serializable;

public class Student implements Serializable {
    private long  id;
    private String sname;
    private long age;
    private String nj;
    private String bb;
    private String sno;

    public long getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public long getAge() {
        return age;
    }

    public String getNj() {
        return nj;
    }

    public String getBb() {
        return bb;
    }

    public String getSno() {
        return sno;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
