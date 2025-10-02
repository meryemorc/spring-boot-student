package com.studentDemo.spring_boot_student.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Column(unique = true)
    private int studentNumber;

    private String className;
    private char branch;
    private Double gpa;

    @ManyToMany
    private List<Course> courses;
}
