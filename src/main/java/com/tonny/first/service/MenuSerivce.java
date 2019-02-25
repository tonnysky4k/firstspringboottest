package com.tonny.first.service;

import com.tonny.first.dao.TMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuSerivce {

    List<TMenu> selectM1();
    List<TMenu> selectM2(Long id);
    void insertMenu(TMenu m);
    void updateMenu(TMenu m);

}
