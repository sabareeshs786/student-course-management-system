package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Welcome to LearnTrack               ");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> studentMenu();
                case 2 -> courseMenu();
                case 3 -> enrollmentMenu();
                case 0 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("----------------------------------------");
        System.out.println("  Main Menu");
        System.out.println("----------------------------------------");
        System.out.println("  1. Student Management");
        System.out.println("  2. Course Management");
        System.out.println("  3. Enrollment Management");
        System.out.println("  0. Exit");
        System.out.println("----------------------------------------");
    }

    private static void studentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  -- Student Management --");
            System.out.println("  1. Add new student");
            System.out.println("  2. View all students");
            System.out.println("  3. Search student by ID");
            System.out.println("  4. Update student");
            System.out.println("  5. Deactivate student");
            System.out.println("  0. Back");
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> StudentService.listStudents();
                case 3 -> searchStudentById();
                case 4 -> updateStudent();
                case 5 -> deactivateStudent();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private static void addStudent() {
        System.out.println("\n  Add New Student");
        String firstName = readString("  First name: ");
        String lastName  = readString("  Last name:  ");
        String email     = readString("  Email (leave blank to skip): ");
        String batch     = readString("  Batch:      ");

        if (email.isBlank()) {
            StudentService.addStudent(firstName, lastName, batch);
        } else {
            StudentService.addStudent(firstName, lastName, email, batch);
        }
        System.out.println("[✓] Student added successfully.\n");
    }

    private static void searchStudentById() {
        int id = readInt("  Enter student ID: ");
        try {
            Student s = StudentService.getStudentById(id);
            System.out.println("\n  ID:         " + s.getId());
            System.out.println("  Name:       " + s.getDisplayName());
            System.out.println("  Email:      " + (s.getEmail() != null ? s.getEmail() : "—"));
            System.out.println("  Batch:      " + s.getBatch());
            System.out.println("  Active:     " + s.getActive());
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void updateStudent() {
        int id = readInt("  Enter student ID to update: ");
        System.out.println("  (Leave any field blank to keep the current value)");
        String firstName = readString("  New first name: ");
        String lastName  = readString("  New last name:  ");
        String email     = readString("  New email:      ");
        String batch     = readString("  New batch:      ");

        try {
            StudentService.updateStudent(
                    id,
                    firstName.isBlank()  ? null : firstName,
                    lastName.isBlank()   ? null : lastName,
                    email.isBlank()      ? null : email,
                    batch.isBlank()      ? null : batch,
                    null   // active unchanged via this flow
            );
            System.out.println("[✓] Student updated successfully.\n");
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void deactivateStudent() {
        int id = readInt("  Enter student ID to deactivate: ");
        try {
            StudentService.removeStudent(id);
            System.out.println("[✓] Student deactivated successfully.\n");
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void courseMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  -- Course Management --");
            System.out.println("  1. Add new course");
            System.out.println("  2. View all courses");
            System.out.println("  3. Activate / Deactivate a course");
            System.out.println("  0. Back");
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addCourse();
                case 2 -> CourseService.listCourses();
                case 3 -> toggleCourse();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private static void addCourse() {
        System.out.println("\n  Add New Course");
        String name        = readString("  Course name:        ");
        String description = readString("  Description:        ");
        int    duration    = readInt("  Duration (weeks):   ");
        CourseService.addCourse(name, description, duration);
        System.out.println("Course added successfully.\n");
    }

    private static void toggleCourse() {
        int id = readInt("  Enter course ID: ");
        System.out.println("  1. Activate   2. Deactivate");
        int choice = readInt("  Choice: ");
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid option.\n");
            return;
        }
        try {
            boolean activate = (choice == 1);
            CourseService.activateOrDeactivate(id, activate);
            System.out.println("Course " + (activate ? "activated" : "deactivated") + " successfully.\n");
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void enrollmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n  -- Enrollment Management --");
            System.out.println("  1. Enroll a student in a course");
            System.out.println("  2. View enrollments for a student");
            System.out.println("  3. Mark enrollment as Completed");
            System.out.println("  4. Mark enrollment as Cancelled");
            System.out.println("  0. Back");
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> enrollStudent();
                case 2 -> viewEnrollments();
                case 3 -> updateEnrollmentStatus(EnrollmentStatus.COMPLETED);
                case 4 -> updateEnrollmentStatus(EnrollmentStatus.CANCELLED);
                case 0 -> back = true;
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private static void enrollStudent() {
        int studentId = readInt("  Enter student ID: ");
        int courseId  = readInt("  Enter course ID:  ");
        try {
            // Validate both entities exist before enrolling
            StudentService.getStudentById(studentId);
            CourseService.getCourseById(courseId);
            EnrollmentService.enrollStudent(studentId, courseId);
            System.out.println("Student enrolled successfully.\n");
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void viewEnrollments() {
        int studentId = readInt("  Enter student ID: ");
        try {
            EnrollmentService.viewEnrollmentsForStudent(studentId);
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static void updateEnrollmentStatus(EnrollmentStatus newStatus) {
        int id = readInt("  Enter enrollment ID: ");
        try {
            EnrollmentService.updateEnrollment(id, newStatus);
            System.out.println("Enrollment marked as " + newStatus + ".\n");
        } catch (EntityNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage() + "\n");
        }
    }

    private static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            // Blank is allowed for optional fields — callers decide what to do with it.
            return line;
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
            }
        }
    }
}
