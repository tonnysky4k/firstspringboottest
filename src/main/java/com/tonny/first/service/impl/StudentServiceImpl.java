package com.tonny.first.service.impl;

import com.tonny.first.dao.Student;
import com.tonny.first.mapper.StudentMapper;
import com.tonny.first.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

    @Override
    public Student selectStudnetById(Long id)
    {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public void insertStudent(Student s )
    {
        studentMapper.insertStudent(s);
    }

    @Override
    public void delelteStudent(Student s)
    {
        studentMapper.deleteStudent(s);
    }

}
