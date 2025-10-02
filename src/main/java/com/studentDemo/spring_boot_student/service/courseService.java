package com.studentDemo.spring_boot_student.service;

import com.studentDemo.spring_boot_student.entity.Course;
import com.studentDemo.spring_boot_student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class courseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course ){
        return courseRepository.save(course);
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Ders bulunamadı"));
    }
}
