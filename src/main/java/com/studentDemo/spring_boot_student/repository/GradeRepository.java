package com.studentDemo.spring_boot_student.repository;


import com.studentDemo.spring_boot_student.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findByStudentId(int studentId);
    List<Grade> findByCourseCode(String courseCode);

}
