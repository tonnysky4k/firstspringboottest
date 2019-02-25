package com.tonny.first.controller;

import com.tonny.first.dao.Option;
import com.tonny.first.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {

    @Autowired
    OptionService optionService;

    @RequestMapping(value="/option",method = RequestMethod.POST)
    public List<Option> queryOption(String stype)
    {
        return optionService.selectByType(stype);
    }
}
