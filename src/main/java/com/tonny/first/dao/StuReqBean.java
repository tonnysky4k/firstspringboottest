package com.tonny.first.dao;

import java.io.Serializable;
import java.util.List;

public class StuReqBean implements Serializable {
    private List<Student>  students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
