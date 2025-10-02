package com.studentDemo.spring_boot_student.controller;

import com.studentDemo.spring_boot_student.service.studentService;
import com.studentDemo.spring_boot_student.entity.Student;
import com.studentDemo.spring_boot_student.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private studentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{studentNumber}/courses")
    public List<Course> getStudentCourses(@PathVariable int studentNumber) {
        return studentService.getStudentCourses(studentNumber);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{number}")
    public Student getStudent(@PathVariable int number){
        return studentService.findByNumber(number);
    }
    @PostMapping("/{studentNumber}/courses/{courseId}")
    public void addCourseToStudent(@PathVariable int studentNumber, @PathVariable Long courseId) {
        studentService.addCourseToStudent(studentNumber, courseId);
    }
}
