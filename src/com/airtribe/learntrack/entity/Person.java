package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.exception.InvalidInputException;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) throws InvalidInputException {
        if(id <= 0){
            throw new InvalidInputException("Invalid id provided");
        }
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName(){
        return this.firstName + " " + this.lastName;
    }
}
