package com.example.demo3;


        import java.io.*;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.Date;

public class AttendanceTracker {
    private ArrayList<Student> students;
    private ArrayList<Attendance> attendanceRecords;

    public AttendanceTracker() {
        this.students = new ArrayList<>();
        this.attendanceRecords = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void recordAttendance(int studentId, boolean isPresent) {
        Attendance attendance = new Attendance(studentId, new Date(), isPresent);
        attendanceRecords.add(attendance);
    }

    public void sortStudentsById() {
        Collections.sort(students, Comparator.comparingInt(Student::getStudentId));
    }

    public void sortAttendanceRecords() {
        Collections.sort(attendanceRecords, Comparator.comparingInt(t -> Attendance.getStudentId(t)));
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            oos.writeObject(attendanceRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (ArrayList<Student>) ois.readObject();
            attendanceRecords = (ArrayList<Attendance>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printAttendanceRecords() {
        for (Attendance attendance : attendanceRecords) {
            System.out.println(attendance);
        }
    }
}

