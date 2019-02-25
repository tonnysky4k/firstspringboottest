package com.tonny.first.mapper;

import com.tonny.first.dao.TMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

     List<TMenu> selectM1();
     List<TMenu> selectM2(Long id);
     void insertMenu(TMenu m);
     void updateMenu(TMenu m);
}
