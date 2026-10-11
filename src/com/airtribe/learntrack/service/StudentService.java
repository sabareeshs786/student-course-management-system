package com.airtribe.learntrack.service;

import com.airtribe.learntrack.db.StudentDB;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    public static void addStudent(String firstName, String lastName, String batch){
        int id = IdGenerator.getNextStudentId();

        //By default, the student is set to active
        Student student = new Student(id, firstName, lastName, batch, true);
        StudentDB.addStudent(student);
    }

    public static void addStudent(String firstName, String lastName, String email, String batch){
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch, true);
        StudentDB.addStudent(student);
    }

    public static Student getStudentById(int id) throws EntityNotFoundException {
        return StudentDB.getStudentById(id);
    }

    public static void listStudents(){
        List<Student> students = StudentDB.getAllStudents();
        for(int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            System.out.println("Student " + (i + 1));
            System.out.println("Id: " + s.getId());
            System.out.println("First name: " + s.getFirstName());
            System.out.println("Last name: " + s.getLastName());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Batch: " + s.getBatch());
            System.out.println("Active: " + s.getActive());
        }
    }

    public static void updateStudent(int id, String firstName, String lastName, String email, String batch, Boolean active) throws EntityNotFoundException {
        Student student = StudentDB.getStudentById(id);
        student.setFirstName(firstName != null ? firstName : student.getFirstName());
        student.setLastName(lastName != null ? lastName : student.getLastName());
        student.setEmail(email != null ? email : student.getEmail());
        student.setBatch(batch != null ? batch : student.getBatch());
        student.setActive(active != null ? active : student.getActive());
    }

    // Deactivating the student instead of deleting
    public static void removeStudent(int id) throws EntityNotFoundException {
        Student student = StudentDB.getStudentById(id);
        student.setActive(false);
    }
}
