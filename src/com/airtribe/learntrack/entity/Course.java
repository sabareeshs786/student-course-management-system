package com.airtribe.learntrack.entity;

public class Course {

    public Course() {}

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private Boolean active;

    public Course(int id, String courseName, String description, int durationInWeeks, Boolean active){
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getDurationInWeeks() {
        return this.durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks){
        this.durationInWeeks = durationInWeeks;
    }

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

}
