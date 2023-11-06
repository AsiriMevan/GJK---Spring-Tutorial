package com.gjk.tutorial.service;

import com.gjk.tutorial.domain.Student;
import com.gjk.tutorial.exception.GjKException;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Integer id) throws GjKException;

    Student getStudentByName(String name);

    Student updateStudentById(Student student, Integer id);

    Student deleteStudentById(Integer id);

}
