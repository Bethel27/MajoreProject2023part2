package com.example.demo3;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;

public class Attendance implements Serializable
{
    private int studentId;
    private Date date;
    private boolean isPresent;

    // Additional structures
    private static Stack<Attendance> attendanceStack = new Stack<>();
    private static LinkedList<Attendance> attendanceList = new LinkedList<>();

    public Attendance(int studentId, Date date, boolean isPresent) {
        this.studentId = studentId;
        this.date = date;
        this.isPresent = isPresent;

        // Add each attendance instance to the stack and linked list
        attendanceStack.push(this);
        attendanceList.add(this);
    }

    // Getters and toString method...

    // Additional methods for stack and linked list
    public static Stack<Attendance> getAttendanceStack() {
        return attendanceStack;
    }

    public static LinkedList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public static <T> int getStudentId(T t) {
        return 0;
    }
}