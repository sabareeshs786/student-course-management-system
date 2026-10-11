package com.airtribe.learntrack.db;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private static final List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        students.add(student);
    }

    public static Student getStudentById(int id) throws EntityNotFoundException {
        for(Student s: students){
            if(s.getId() == id) return s;
        }
        throw new EntityNotFoundException("Student with the specified id is not found");
    }

    public static List<Student> getAllStudents(){
        return students;
    }
}
