package com.tonny.first.mapper;

import com.tonny.first.dao.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    List<Option> selectByType(String stype);
}
