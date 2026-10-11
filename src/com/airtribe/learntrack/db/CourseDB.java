package com.airtribe.learntrack.db;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {

    private static final List<Course> courses = new ArrayList<>();

    public static void addCourse(Course course){
        courses.add(course);
    }

    public static List<Course> getAllCourses(){
        return courses;
    }

    public static Course getCourseById(int id) throws EntityNotFoundException {
        for(Course course: courses){
            if(course.getId() == id) return course;
        }
        throw new EntityNotFoundException("Course with the specified id is not found");
    }

    public static String getCourseNameById(int id) throws EntityNotFoundException {
        for(Course course: courses){
            if(course.getId() == id) return course.getCourseName();
        }
        throw new EntityNotFoundException("Course with the specified id is not found");
    }
}
