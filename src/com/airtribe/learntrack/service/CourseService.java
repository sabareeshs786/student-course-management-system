package com.airtribe.learntrack.service;

import com.airtribe.learntrack.db.CourseDB;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {

    public static void addCourse(String courseName, String description, int durationInWeeks){
        int id = IdGenerator.getNextCourseId();

        //By default, the course is set to active
        Course course = new Course(id, courseName, description, durationInWeeks, true);

        CourseDB.addCourse(course);
    }

    public static Course getCourseById(int id) throws EntityNotFoundException {
        return CourseDB.getCourseById(id);
    }

    public static void listCourses(){
        List<Course> courses = CourseDB.getAllCourses();
        System.out.println("List of all the courses");
        for(Course course: courses){
            System.out.println("Course id: " + course.getId());
            System.out.println("Course name: " + course.getCourseName());
            System.out.println("Course description: " + course.getDescription());
            System.out.println("Course duration: " + course.getDurationInWeeks());
            System.out.println("Course active: " + course.getActive());
        }
    }

    public static void updateCourse(int id, String courseName, String description,
                                    Integer durationInWeeks, Boolean active) throws EntityNotFoundException {
        Course course = CourseDB.getCourseById(id);
        course.setCourseName(courseName != null ? courseName : course.getCourseName());
        course.setDescription(description != null ? description : course.getDescription());
        course.setDurationInWeeks(durationInWeeks != null ? durationInWeeks : course.getDurationInWeeks());
        course.setActive(active != null ? active : course.getActive());
    }

    public static void activateOrDeactivate(int courseId, boolean active) throws EntityNotFoundException {
        CourseDB.getCourseById(courseId).setActive(active);
    }
}
