package com.gjk.tutorial.serviceImpl;

import com.gjk.tutorial.domain.Student;
import com.gjk.tutorial.exception.ErrorCode;
import com.gjk.tutorial.exception.GjKException;
import com.gjk.tutorial.repository.StudentRepository;
import com.gjk.tutorial.service.StudentService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) throws GjKException {
        Optional<Student> studentObj = studentRepository.findById(id);
        if (!studentObj.isPresent()) {
            throw new GjKException(ErrorCode.STUDENT_ID_WITH_NO_DATA_FOUND);
        }
        return studentObj.get();
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student updateStudentById(Student student, Integer id) {
        Student studentObj = studentRepository.findById(id).get();
        if (StringUtils.isNotEmpty(student.getName())) {
            studentObj.setName(student.getName());
        }
        if (StringUtils.isNotEmpty(student.getAddress())) {
            studentObj.setAddress(student.getAddress());
        }
        if (ObjectUtils.isNotEmpty(student.getRollNo())) {
            studentObj.setRollNo(student.getRollNo());
        }
        return studentRepository.save(studentObj);
    }

    @Override
    public Student deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
        return null;
    }
}
