package com.student.studentRegistration.repositories;

import com.student.studentRegistration.Beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface studentRepository extends JpaRepository<Student, Integer> {
}
