package com.studentDemo.spring_boot_student.service;

import com.studentDemo.spring_boot_student.entity.Grade;
import com.studentDemo.spring_boot_student.entity.Student;
import com.studentDemo.spring_boot_student.repository.GradeRepository;
import com.studentDemo.spring_boot_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class gradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Grade addGrade(int studentId, String courseCode, double gradeValue){
        Grade grade= new Grade();
        grade.setStudentId(studentId);
        grade.setCourseCode(courseCode);
        grade.setGrade(gradeValue);

        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long gradeId, double newGrade){
        Grade grade=gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade bulunamadı"));

        grade.setGrade(newGrade);

        return gradeRepository.save(grade);

    }

    public List<Grade> getStudentGrades(int studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        if(grades.isEmpty()) {
            return new ArrayList<>();
        }
        return grades;
    }

    public List<Grade> getGradesByCourseCode(String courseCode) {
        List<Grade> grades = gradeRepository.findByCourseCode(courseCode);
        return gradeRepository.findByCourseCode(courseCode);
    }
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
