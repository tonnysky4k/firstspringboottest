package com.tonny.first.service.impl;

import com.tonny.first.dao.TMenu;
import com.tonny.first.mapper.MenuMapper;
import com.tonny.first.service.MenuSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuSericeImpl implements MenuSerivce {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<TMenu> selectM1()
    {
        return menuMapper.selectM1();
    }
    @Override
    public List<TMenu> selectM2(Long id)
    {
        return menuMapper.selectM2(id);
    }
    @Override
    public void insertMenu(TMenu u)
    {
        menuMapper.insertMenu(u);
    }
    public void updateMenu(TMenu u)
    {
        menuMapper.updateMenu(u);
    }
}
