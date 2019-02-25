package com.tonny.first.mapper;

import com.tonny.first.dao.SMSEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SMSMapper {
    void insertSMS(SMSEntity s);
}
