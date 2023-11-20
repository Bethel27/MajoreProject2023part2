package com.example.demo3;

import java.io.Serializable;


public class Student implements Serializable {
    private String name;
    private int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId; // Return the actual studentId field
    }

    // Other getters and toString method...
}

