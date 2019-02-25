package com.tonny.first;

import com.tonny.first.dao.SMSEntity;
import com.tonny.first.service.SMSService;
import com.tonny.first.service.impl.SMSServiceImpl;
import com.tonny.first.utils.MailContentTypeEnum;
import com.tonny.first.utils.MailSender;
import com.tonny.first.utils.SendSMS;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static javax.xml.transform.OutputKeys.ENCODING;

public class TonnySpringApplicationTest {

    @Test
    public void main() {
        /* 邮件测试 163邮箱，QQ邮箱都没问题了*/
        try {
            mailTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void mailTest ()  throws Exception {
            MailSender mailSender = new MailSender().title("tonny").
                    content("尹涛的虚拟货币测试邮件！").
                    contentType(MailContentTypeEnum.TEXT).targets(new ArrayList<String>() {{
                add("279253462@qq.com");
                add("845288322@qq.com");
            }});
            mailSender.send();
        }
    }
