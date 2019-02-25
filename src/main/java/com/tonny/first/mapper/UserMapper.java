package com.tonny.first.mapper;

import com.tonny.first.dao.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> selectAll();
    void insertUser(User u);
    void updateUser(User u);
    void deleteUser(User u);
    User selectUserById(Long id);
    List<User> callProc(Map<String,Object> h);
    Long userlogin(User u);
}
