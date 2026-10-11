package com.airtribe.learntrack.entity;

import java.util.Date;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private Date enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, int studentId, int courseId, Date enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getEnrollmentDate() {
        return this.enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
