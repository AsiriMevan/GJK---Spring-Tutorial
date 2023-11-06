package com.gjk.tutorial.repository;

import com.gjk.tutorial.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByName(String name);
}
