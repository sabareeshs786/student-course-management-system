package com.airtribe.learntrack.entity;


public class Trainer extends Person {

    private String specialisation;

    public Trainer() {
        super(0, "", "");
    }

    public Trainer(int id, String firstName, String lastName, String specialisation) {
        super(id, firstName, lastName);
        this.specialisation = specialisation;
    }

    public Trainer(int id, String firstName, String lastName, String email, String specialisation) {
        super(id, firstName, lastName, email);
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


    @Override
    public String getDisplayName() {
        return "Trainer: " + getFirstName() + " " + getLastName()
                + " [" + specialisation + "]";
    }
}
