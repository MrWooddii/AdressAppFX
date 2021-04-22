package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class addPersonController {

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
    private TextField birthdateText;

    @FXML
    public Button addContactbutton;

    @FXML
    private Button resetButton;

    private Person person;

    @FXML
    public void addContact() {

        this.addContactbutton.setOnAction(event -> {
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String street = streetText.getText();
            String city = cityText.getText();
            String postalCode = postalText.getText();
            String phoneNumber = phoneText.getText();
            String birthdate = birthdateText.getText();

            this.person = new Person(firstName, lastName, street, city, postalCode, birthdate, phoneNumber);
        });

    }

    @FXML
    public void reset() {
        this.firstNameText.clear();
        this.lastNameText.clear();
        this.streetText.clear();
        this.cityText.clear();
        this.postalText.clear();
        this.birthdateText.clear();
        this.phoneText.clear();
    }

    public Button getAddContactButton() {
        return this.addContactbutton;
    }

    public Person getPerson() {
        return this.person;
    }

}
