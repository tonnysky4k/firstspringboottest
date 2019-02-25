package com.tonny.first.service;

import com.tonny.first.dao.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> selectAll();
    Student selectStudnetById(Long id);
    void insertStudent(Student s);
    void delelteStudent(Student s);
}
