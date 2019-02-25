package com.tonny.first.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tonny.first.dao.PageBean;
import com.tonny.first.dao.StuReqBean;

import com.tonny.first.dao.Student;
import com.tonny.first.dao.User;
import com.tonny.first.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/student", method=RequestMethod.GET)
    public String index(@ModelAttribute(value="studentBean") Student stu , ModelMap model)
    {
        return "student";
    }
    @RequestMapping(value="/addStudent",method=RequestMethod.POST)
    public String addStudent(@ModelAttribute(value="studentBean") Student stu , ModelMap model)
    {
       if(stu.getId()!=0)
         studentService.insertStudent(stu);
       System.out.println("student="+stu);
        return "student";
    }

    @RequestMapping("/students")
    public String stuList(Model model)
    {

        List<Student> stus =studentService.selectAll();
       // PageBean<Student> pageData = new PageBean<>(1,10,34);
      //  pageData.setItems(stus);
        model.addAttribute("students",stus);
        return "studentlist";
    }
}
