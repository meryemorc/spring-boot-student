package com.studentDemo.spring_boot_student.controller;

import com.studentDemo.spring_boot_student.entity.Grade;
import com.studentDemo.spring_boot_student.service.gradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @Autowired
    private gradeService gradeService;

    @PostMapping
    public Grade addGrade(@RequestParam int studentId,
                          @RequestParam String courseCode,
                          @RequestParam double grade){
        return gradeService.addGrade(studentId,courseCode,grade);
    }
    @PutMapping("/{gradeId}")
    public Grade UpdateGrade(@PathVariable Long gradeId,
                             @RequestParam double newGrade){
        return gradeService.updateGrade(gradeId,newGrade);
    }
    @GetMapping("/student/{studentId}")
    public List<Grade> getStudentGrades(@PathVariable int studentId){
        return gradeService.getStudentGrades(studentId);
    }
    @GetMapping("/course/{courseCode}")
    public List<Grade> getGradesByCourse(@PathVariable String courseCode){
        return gradeService.getGradesByCourseCode(courseCode);
    }
    @DeleteMapping("/{gradeId}")
    public void deleteGrade(@PathVariable Long gradeId){
        gradeService.deleteGrade(gradeId);
    }

}
