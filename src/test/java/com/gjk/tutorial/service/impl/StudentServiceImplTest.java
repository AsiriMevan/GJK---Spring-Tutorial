package com.gjk.tutorial.service.impl;

import com.gjk.tutorial.domain.Student;
import com.gjk.tutorial.exception.GjKException;
import com.gjk.tutorial.repository.StudentRepository;
import com.gjk.tutorial.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        Optional<Student> student = Optional.of(new Student(1, "Service", 100, "TestService"));
        Mockito.when(studentRepository.findById(1)).thenReturn(student);
    }

    @Test
    public void testGetStudentById_Success() throws GjKException {
        String student_name = "Service";

        Student studentId = studentService.getStudentById(1);
        assertEquals(student_name, studentId.getName());
    }
}
