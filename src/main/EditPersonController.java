package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditPersonController {

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField streetText;

    @FXML
    private TextField cityText;

    @FXML
    private TextField postalText;

    @FXML
    private TextField phoneText;

    @FXML
    private DatePicker birthdateText;

    @FXML
    private Button editContactButton;

    @FXML
    private Button resetButton;

    @FXML
    public void setTextField(Person person) {
        //set Textfields to the current data
        firstNameText.setText(person.getFirstName());
        lastNameText.setText(person.getLastName());
        streetText.setText(person.getStreet());
        cityText.setText(person.getCity());
        postalText.setText(person.getPostalCode());
        phoneText.setText(person.getPhoneNumber());

        birthdateText.getEditor().setText(person.getBirthdate());
    }

    @FXML
    public void editContact(Person person) {
        //save changes to the person when "Edit Contact" is clicked
        person.setFirstName(firstNameText.getText());
        person.setLastName(lastNameText.getText());
        person.setStreet(streetText.getText());
        person.setCity(cityText.getText());
        person.setPostalCode(postalText.getText());
        person.setPhoneNumber(phoneText.getText());

        if(birthdateText.getValue() != null) {
            person.setBirthdate(String.valueOf(birthdateText.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        } else {
            person.setBirthdate(birthdateText.getEditor().getText());
        }


        //close edit window
        this.editContactButton.getScene().getWindow().hide();
    }

    @FXML
    public void reset() {
        //empty all TextFields
        this.firstNameText.clear();
        this.lastNameText.clear();
        this.streetText.clear();
        this.cityText.clear();
        this.postalText.clear();
        this.birthdateText.setValue(null);
        this.phoneText.clear();
    }

    public Button getEditContactButton() {
        return this.editContactButton;
    }

    public String getFirstName() {
        return firstNameText.getText();
    }

    public void setFirstName(String firstName) {
        this.firstNameText.setText(firstName);
    }

    public String getLastName() {
        return lastNameText.getText();
    }

    public void setLastName(String lastName) {
        this.lastNameText.setText(lastName);
    }

    public String getStreet() {
        return streetText.getText();
    }

    public void setStreet(String street) {
        this.streetText.setText(street);
    }

    public String getCity() {
        return cityText.getText();
    }

    public void setCity(String city) {
        this.cityText.setText(city);
    }

    public String getPostal() {
        return postalText.getText();
    }

    public void setPostal(String postalCode) {
        this.postalText.setText(postalCode);
    }

    public String getPhone() {
        return phoneText.getText();
    }

    public void setPhone(String phoneNumber) {
        this.phoneText.setText(phoneNumber);
    }

    public LocalDate getBirthdate() {
        return birthdateText.getValue();
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdateText.setValue(birthdate);
    }

}
