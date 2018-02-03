package VolunteerApp.models;

import java.io.File;
import java.time.LocalDate;

public class Volunteer {
    private String firstName, lastName, phoneNumber;
    private LocalDate birthDay;
    private File imageFile;

    public Volunteer(String firstName, String lastName, String phoneNumber, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.imageFile = new File("./images/defaultPerson.jpg");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
