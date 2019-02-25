package com.tonny.first.utils;

import com.tonny.first.dao.MailEntity;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

public class MailSender {
    private MailEntity mailEntity =new MailEntity();
    public MailSender title(String title)
    {
        mailEntity.setTitle(title);
        return this;
    }
    public MailSender content(String content)
    {
        mailEntity.setContent(content);
        return this;
    }
    public MailSender contentType(MailContentTypeEnum typeEnum)
    {
        mailEntity.setContentType(typeEnum.getValue());
        return this;
    }
    public MailSender targets(List<String> targets)
    {
        mailEntity.setToMailAddr(targets);
        return this;
    }
    public void send() throws  Exception
    {
        if(mailEntity.getContentType() == null)
            mailEntity.setContentType(MailContentTypeEnum.HTML.getValue());
        if(mailEntity.getTitle()== null ||  mailEntity.getTitle().length()==0)
        {
            throw new Exception("title is not all null");
        }
        if(mailEntity.getContent() == null || mailEntity.getContent().trim().length() == 0)
        {
            throw new Exception("邮件内容没有设置.调用content方法设置");
        }

        // 0104 接收者邮箱地址验证，如果没有就抛出异常
        if(mailEntity.getToMailAddr().size() == 0)
        {
            throw new Exception("没有接受者邮箱地址.调用targets方法设置");
        }
        final PropertiesUtil properties = new PropertiesUtil("mail");
        // 创建Properties 类用于记录邮箱的一些属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        //设置端口号，QQ邮箱给出了两个端口465/587
        props.put("mail.smtp.port", properties.getValue("mail.smtp.port"));
        // 设置发送邮箱
        props.put("mail.user", properties.getValue("mail.from.address"));
        // 设置发送邮箱的16位STMP口令
        props.put("mail.password", properties.getValue("mail.from.smtp.pwd"));
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + " <" + props.getProperty("mail.user") + ">");
        message.setFrom(form);

        // 设置邮件标题
        message.setSubject(mailEntity.getTitle());
        //html发送邮件
        if(mailEntity.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            // 设置邮件的内容体
            message.setContent(mailEntity.getContent(), mailEntity.getContentType());
        }
        //文本发送邮件
        else if(mailEntity.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
            message.setText(mailEntity.getContent());
        }
        //发送邮箱地址
        List<String> targets = mailEntity.getToMailAddr();
        for(int i = 0;i < targets.size();i++){
            try {
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                // 最后当然就是发送邮件啦
                Transport.send(message);
            } catch (Exception e) {
                continue;
            }
        }
    }
}
