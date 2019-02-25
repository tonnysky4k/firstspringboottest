package com.tonny.first.dao;

import java.util.List;

public class MenuVo {
    private String  name;
    private List<TMenu> subs;
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public List<TMenu> getSubs() {
        return subs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubs(List<TMenu> subs) {
        this.subs = subs;
    }
}
