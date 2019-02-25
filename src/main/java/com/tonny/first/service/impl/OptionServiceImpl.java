package com.tonny.first.service.impl;

import com.tonny.first.dao.Option;
import com.tonny.first.mapper.OptionMapper;
import com.tonny.first.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionMapper optionMapper;
    @Override
    public List<Option> selectByType(String stype)
    {
        return optionMapper.selectByType(stype);
    }
}
