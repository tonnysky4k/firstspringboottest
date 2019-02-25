package com.tonny.first.service;

import com.tonny.first.dao.Option;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionService {
    List<Option> selectByType(String stype);
}
