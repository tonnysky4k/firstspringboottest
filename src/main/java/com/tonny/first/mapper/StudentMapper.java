package com.tonny.first.mapper;

import com.tonny.first.dao.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
    Student selectStudentById(long id);
    void insertStudent(Student s);
    void deleteStudent(Student s);
}
