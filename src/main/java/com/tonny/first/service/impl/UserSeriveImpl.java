package com.tonny.first.service.impl;

import com.tonny.first.dao.User;
import com.tonny.first.mapper.UserMapper;
import com.tonny.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserSeriveImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUsers()
    {
        return userMapper.selectAll();
    }
    @Override
    public void insertUser(User u)
    {
        userMapper.insertUser(u);
    }
    @Override
    public void deleteUser(User u)
    {
        userMapper.deleteUser(u);
    }
    @Override
    public void updateUser(User u)
    {
        userMapper.updateUser(u);
    }
    @Override
    public List<User> callProc(Map<String,Object> h)
    {
        return userMapper.callProc(h);
    }
    @Override
    public User selectUserById(Long id)
    {
        return userMapper.selectUserById(id);
    }

    @Override
    public Long userLogin(User u)
    {
        return userMapper.userlogin(u);
    }
}
