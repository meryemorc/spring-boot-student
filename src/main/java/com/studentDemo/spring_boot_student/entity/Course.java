package com.studentDemo.spring_boot_student.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String courseName;
    private String courseCode;
    private String courseCredit;

    @OneToMany
    private List<Grade> grades;

}
