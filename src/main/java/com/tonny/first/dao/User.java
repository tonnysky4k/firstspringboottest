package com.tonny.first.dao;

public class User {
    private long id;
    private String name;
    private String password;
    private int logstat ;
    private String ip;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getLogstat() {
        return logstat;
    }

    public String getIp() {
        return ip;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String username) {
        this.name = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogstat(int logstat) {
        this.logstat = logstat;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
