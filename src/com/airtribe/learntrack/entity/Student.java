package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private Boolean active;

    public Student(int id, String firstName, String lastName, String batch, Boolean active){
        super(id, firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String email, String batch, Boolean active){
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public String getBatch(){
        return this.batch;
    }

    public void setBatch(String batch){
        this.batch = batch;
    }

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    @Override
    public String getDisplayName(){
        return getFirstName();
    }
}
