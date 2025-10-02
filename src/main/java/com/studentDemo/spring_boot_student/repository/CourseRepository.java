package com.studentDemo.spring_boot_student.repository;

import com.studentDemo.spring_boot_student.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
