package com.gjk.tutorial.controller;

import com.gjk.tutorial.domain.Student;
import com.gjk.tutorial.exception.GjKException;
import com.gjk.tutorial.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public Student addStudent(@Valid @RequestBody Student student) {
        LOGGER.info("addStudentRequest: Created new Student.|student={}", student);
        return studentService.addStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudent() {
        LOGGER.info("getAllStudentRequest: Found All Student Details.");
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) throws GjKException {
        LOGGER.info("getStudentByIdRequest: Found Student Details through th Student ID.|id={}", id);
        return studentService.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable("name") String name) {
        LOGGER.info("getStudentByNameRequest: Found Student Details through th Student Name.|name={}", name);
        return studentService.getStudentByName(name);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@RequestBody Student student, @PathVariable("id") Integer id) {
        LOGGER.info("updateStudentByIdRequest: Update Student Details.|student={}|id={}", student, id);
        return studentService.updateStudentById(student, id);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable("id") Integer id) {
        LOGGER.info("deleteStudentByIdRequest: Delete Student Details through th Student ID.|id={}", id);
        return studentService.deleteStudentById(id);
    }

}
