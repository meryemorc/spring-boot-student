package com.studentDemo.spring_boot_student.service;

import com.studentDemo.spring_boot_student.entity.Student;
import com.studentDemo.spring_boot_student.entity.Course;
import com.studentDemo.spring_boot_student.service.courseService;
import com.studentDemo.spring_boot_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private courseService courseService;

    public Student addStudent(Student student) {
        if (studentRepository.findByStudentNumber(student.getStudentNumber()).isPresent()) {
            throw new RuntimeException("Bu numarayla öğrenci var başka bir numara dene");
        }
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {


        return studentRepository.findAll();
    }

    public List<Course> getStudentCourses(int studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new RuntimeException("öğrenci bulunamadı"));
        return student.getCourses();
    }

    public Student findByNumber(int number) {
        return studentRepository.findByStudentNumber(number)
                .orElseThrow(() -> new RuntimeException("Student bulunmadı"));
    }

    public void addCourseToStudent(int studentNumber, Long courseId) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new RuntimeException("öğrenci bulunamadı"));

        Course course = courseService.findById(courseId);

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
