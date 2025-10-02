package com.studentDemo.spring_boot_student.repository;

import com.studentDemo.spring_boot_student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(int studentNumber);

}
