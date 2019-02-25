package com.tonny.first.dao;

import java.util.List;

public class TMenu {
    private Long id;
    private String mname;
    private Long pid;
    private List<TMenu> subs;
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Long getId() {
        return id;
    }

    public String getMname() {
        return mname;
    }

    public Long getPid() {
        return pid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<TMenu> getSubs() {
        return subs;
    }

    public void setSubs(List<TMenu> subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        return "TMenu{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", pid=" + pid +
                ", subs=" + subs +
                '}';
    }
}
