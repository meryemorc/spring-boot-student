package com.studentDemo.spring_boot_student.controller;

import com.studentDemo.spring_boot_student.entity.Course;
import com.studentDemo.spring_boot_student.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private courseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
}
