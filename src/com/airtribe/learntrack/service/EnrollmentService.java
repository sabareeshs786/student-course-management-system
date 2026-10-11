package com.airtribe.learntrack.service;

import com.airtribe.learntrack.db.CourseDB;
import com.airtribe.learntrack.db.EnrollmentDB;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.Date;
import java.util.List;

public class EnrollmentService {

    public static void enrollStudent(int studentId, int courseId){
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, new Date(), EnrollmentStatus.ACTIVE);
        EnrollmentDB.addEnrollment(enrollment);
    }

    public static void viewEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        List<Enrollment> enrollmentList = EnrollmentDB.listAllEnrollments();
        System.out.println("Enrollments of student with id " + studentId);
        for(Enrollment enrollment: enrollmentList){
            if(enrollment.getStudentId() == studentId){
                System.out.println("Course name: " + CourseDB.getCourseNameById(enrollment.getCourseId()));
            }
        }
    }

    public static void updateEnrollment(int id, EnrollmentStatus status) throws EntityNotFoundException {
        List<Enrollment> enrollmentList = EnrollmentDB.listAllEnrollments();
        for(Enrollment enrollment: enrollmentList){
            if(enrollment.getId() == id){
                enrollment.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment with the specified id is not found");
    }
}
