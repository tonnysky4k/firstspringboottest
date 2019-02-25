package com.tonny.first.controller;

import com.tonny.first.dao.MenuVo;
import com.tonny.first.dao.SMSEntity;
import com.tonny.first.dao.TMenu;
import com.tonny.first.dao.User;
import com.tonny.first.service.MenuSerivce;
import com.tonny.first.service.SMSService;
import com.tonny.first.service.UserService;
import com.tonny.first.utils.MailContentTypeEnum;
import com.tonny.first.utils.MailSender;
import com.tonny.first.utils.SendSMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Parameter;
import java.net.URLEncoder;
import java.util.*;
@Api(value = "TestController测试", tags = { "测试接口" })
@Controller
public class TestController {
   private String username;
   private String password;
   @Autowired
    UserService userService;
   @Autowired
    MenuSerivce menuSerivce;
    @Autowired
    private SMSService smsService;
    @RequestMapping("/hello2")
    public String  test()
    {
        return "hello2";
    }
    @RequestMapping("/login2")
    public String login()
    {
        return "login2";
    }
    @ApiOperation("用户登录首页")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @RequestMapping(value = "/main")
    public String  mainframe(@RequestParam("name") String name)
    {
        setUsername(name);

        return "main";
    }

    @RequestMapping("/top")
    public String top(Model model)
    {
        model.addAttribute("username",getUsername());

        return "top";
    }
    @RequestMapping("/footer")
    public String footer()
    {
        return "footer";
    }
    @RequestMapping("/left")
    public String left(Model model)
    {
        List<TMenu> li0 = menuSerivce.selectM1();
        List<MenuVo> list1 =new ArrayList<MenuVo>();
        for(int i=0;i<li0.size();i++)
        {
            TMenu tMenu =li0.get(i);
            MenuVo menuVo = new MenuVo();
            List<TMenu> li2 = menuSerivce.selectM2(tMenu.getId());
            menuVo.setName(tMenu.getMname());
            menuVo.setSubs(li2);
            list1.add(menuVo);
        }
        model.addAttribute("menus",list1);

        return "left";
    }
    @RequestMapping("/right")
            public String right()
    {
        return "index";
    }
    @RequestMapping("/tuser")
    public String userList(Model model)
    {
        List<User> users =userService.getUsers();
        model.addAttribute("users",users);
        return "tab";
    }
    @RequestMapping("user/delete")
    public void deleteUser(Model model,@RequestParam("id") Long id )
    {
        User u  =new User();
        u.setId(id);
        userService.deleteUser(u);
        List<User> users =userService.getUsers();
        //  System.out.println(users);
        model.addAttribute("users",users);
    }
    @RequestMapping("user/query")
    public String queryUser(Model model,@RequestParam("id") Long id)
    {
       User u = userService.selectUserById(id);
       model.addAttribute("user",u);
       return "userdetail";
    }
    @RequestMapping("/menu")
    public String menuList(Model model)
    {
        List<TMenu> li = menuSerivce.selectM1();
        List<TMenu> total = new ArrayList<TMenu>();
        for(int i=0;i<li.size();i++)
        {
            List<TMenu> li2 = menuSerivce.selectM2(li.get(i).getId());
            total.add(li.get(i));
            for( int j =0;j<li2 .size();j++)
                total.add(li2.get(j));
        }
        model.addAttribute("menus",total);
        return "Menu";
    }
    @RequestMapping("/help")
  public String help()
  {
      return "tech";
  }
   @RequestMapping("/mail")
   public String mail(Model model)
   {
       return "sendmail";
   }

   @RequestMapping("/sendmail")
   public void sendmail (String address) throws Exception
   {
       if (address.length()<1 ) return;
       String [] arrys= address.split(";");
       List<String> list = new ArrayList<String>();
      for (int i=0;i< arrys.length;i++)
      {
          list.add(arrys[i]);
      }
       MailSender mailSender = new MailSender().title("tonny").
               content("尹涛的虚拟货币测试邮件！").
               contentType(MailContentTypeEnum.TEXT).targets(list);
       mailSender.send();
   }

   @RequestMapping("/sms")
   public String  sms()
   {
       return "sendsms";
   }
   @RequestMapping("/webchat")
   public String chat()
   {
       return "WebChat";
   }
   @RequestMapping("/sendsms")
   public String sendSMS(String pho) throws Exception
   {
       SMSEntity smsEntity =new SMSEntity();
       System.out.println("tep pho="+pho);
       Random rand = new Random();
       int key =rand.nextInt(10000);
       String s = String.valueOf(key);
       smsEntity.setCode(s);
       smsEntity.setId(key);
       smsEntity.setTopho(pho);
       smsEntity.setSdate(new Date());
       SendSMS sendSMS = new SendSMS();
       String mobile = URLEncoder.encode(pho, "UTF-8");
       String apikey = "cbecc6f67f2d62d675630711a9ea5861";
       String text = "【Newton牛盾】为了保障您的账户安全，因此发送此号码 [" + s + "] 以确认您的身份，请勿将此号码外流。";
       sendSMS.sendSms(apikey, text, mobile);
       smsService.insertSMS(smsEntity);
       return "sendsms";
   }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
