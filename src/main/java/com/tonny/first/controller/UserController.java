package com.tonny.first.controller;

import com.tonny.first.dao.SMSEntity;
import com.tonny.first.dao.TMenu;
import com.tonny.first.dao.User;
import com.tonny.first.service.MenuSerivce;
import com.tonny.first.service.SMSService;
import com.tonny.first.service.UserService;
import com.tonny.first.utils.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    MenuSerivce menuSerivce;
    @Autowired
    private SMSService smsService;
    @RequestMapping("/users")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }
    @RequestMapping("/test")
    String home()
    {
        return "hello .test!";
    }
    @RequestMapping("/insertuser")
    public String  insertUser()
    {
        User u =new User();
        u.setId(0);
        u.setIp("localhost");
        u.setName("tonny100");
        u.setPassword("11111");
        u.setLogstat(0);
        userService.insertUser(u);
        return "success2!";
    }
    @RequestMapping(value="/updateuser",method = RequestMethod.POST)
    public void updateUser(User u)
    {
       if(u==null) return;
        userService.updateUser(u);
    }
    @RequestMapping(value="/deleteuser",method = RequestMethod.POST)
    public void deleteUser(Long id)
    {
        User u = new User();
        u.setId(id);
        userService.deleteUser(u);
    }
    @RequestMapping("/callProc")
    public String callProUser()
    {
        Map<String ,Object> h =new HashMap<String,Object>();
         userService.callProc(h);
         List<User> li =(List<User>)h.get("result");
        return li.toString();
    }

    @RequestMapping(value="/vali-login",method = RequestMethod.POST)
    public Long validateLogin(String username,String password) {
        System.out.println("username="+username);
        System.out.println("password="+password);
        User   u = new User();
        u.setName(username);
        u.setPassword(password);
        return  userService.userLogin(u);
    }
}
