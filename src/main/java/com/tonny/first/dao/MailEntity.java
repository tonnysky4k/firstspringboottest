package com.tonny.first.dao;

import java.io.Serializable;
import java.util.List;

public class MailEntity implements Serializable {
    private String smtpService;
    private String smtpPort;
    private String fromMailAddr;
    private String fromMailPassword;
    private String title;
    private String content;
    private String contentType;
    private List<String> toMailAddr;

    public String getSmtpService() {
        return smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getFromMailAddr() {
        return fromMailAddr;
    }

    public String getFromMailPassword() {
        return fromMailPassword;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }

    public List<String> getToMailAddr() {
        return toMailAddr;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public void setFromMailAddr(String fromMailAddr) {
        this.fromMailAddr = fromMailAddr;
    }

    public void setFromMailPassword(String fromMailPassword) {
        this.fromMailPassword = fromMailPassword;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setToMailAddr(List<String> toMailAddr) {
        this.toMailAddr = toMailAddr;
    }
}
