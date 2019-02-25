package com.tonny.first.service;

import com.tonny.first.dao.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {
     List<User> getUsers();
     void insertUser(User u);
     void updateUser(User u);
     void deleteUser(User u);
     List<User> callProc(Map<String,Object> h);
     User selectUserById(Long id);
     Long userLogin(User u);
}
