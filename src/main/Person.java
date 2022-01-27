package main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String birthdate;
    private String phoneNumber;

    public Person() {
        //default
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, "", "", "", "");
    }

    public Person(String firstName, String lastName, String street, String city, String postalCode, String phoneNumber) {
        this(firstName, lastName, street, city, "", postalCode, phoneNumber);
    }

    public Person(String firstName, String lastName, String street, String city, String birthdate, String postalCode, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.birthdate = birthdate;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
