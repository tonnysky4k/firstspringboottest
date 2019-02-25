package com.tonny.first.service;

import com.tonny.first.dao.SMSEntity;
import org.springframework.stereotype.Service;

@Service
public interface SMSService {
    void insertSMS(SMSEntity smsEntity);
}
