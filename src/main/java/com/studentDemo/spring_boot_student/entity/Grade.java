package com.studentDemo.spring_boot_student.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int studentId;
    private String courseCode;
    private String courseName;
    private double grade;



}
