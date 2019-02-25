package com.tonny.first.service.impl;

import com.tonny.first.dao.SMSEntity;
import com.tonny.first.mapper.SMSMapper;
import com.tonny.first.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {
    @Autowired
    SMSMapper smsMapper;
    @Override
    public void insertSMS(SMSEntity smsEntity)
    {
        smsMapper.insertSMS(smsEntity);
    }
}
