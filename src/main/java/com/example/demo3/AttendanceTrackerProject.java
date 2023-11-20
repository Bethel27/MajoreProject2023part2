package com.example.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AttendanceTrackerProject extends Application {
    private final AttendanceTracker attendanceTracker = new AttendanceTracker();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Attendance Tracker");

        VBox layout = new VBox(10);
        layout.setMinWidth(250);

        Button addStudentButton = new Button("Add Student");
        addStudentButton.setOnAction(e -> {
            // Logic for adding a student...
            // You might want to open a new window or prompt for student details.
         // new AddStudentWindow(attendanceTracker);
        });

        Button recordAttendanceButton = new Button("Record Attendance");
        recordAttendanceButton.setOnAction(e -> {
            // Logic for recording attendance...
            // Example: new RecordAttendanceWindow(attendanceTracker);
        });

        Button sortButton = new Button("Sort Students");
        sortButton.setOnAction(e -> {
            attendanceTracker.sortStudentsById();
            attendanceTracker.printStudents();
        });

        Button saveButton = new Button("Save to File");
        saveButton.setOnAction(e -> {
            attendanceTracker.saveToFile("attendance_data.dat");
            attendanceTracker.printAttendanceRecords();
        });

        Button loadButton = new Button("Load from File");
        loadButton.setOnAction(e -> {
            attendanceTracker.loadFromFile("attendance_data.dat");
            attendanceTracker.printStudents();
            attendanceTracker.printAttendanceRecords();
        });

        layout.getChildren().addAll(addStudentButton, recordAttendanceButton, sortButton, saveButton, loadButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();  // Add this line
    }
}
