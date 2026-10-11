package com.airtribe.learntrack.db;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDB {

    private static final List<Enrollment> enrollments = new ArrayList<>();

    public static void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }

    public static List<Enrollment> listAllEnrollments(){
        return enrollments;
    }
}
