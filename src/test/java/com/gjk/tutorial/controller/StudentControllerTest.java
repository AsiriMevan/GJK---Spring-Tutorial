package com.gjk.tutorial.controller;

import com.gjk.tutorial.domain.Student;
import com.gjk.tutorial.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setup() {
        student = new Student(9, "Controller", 100, "TestController");
    }

    @Test
    public void testAddStudent() throws Exception {
        Student studentN = new Student(9, "Controller", 100, "TestController");
        Mockito.when(studentService.addStudent(studentN)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student/createStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" + " \"id\": 9,\r\n" + " \"name\": \"Controller\",\r\n" +
                                " \"rollNo\": 100,\r\n" +
                                " \"address\": \"TestController\"\r\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
