package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.time.format.DateTimeFormatter;

public class AddPersonController {

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
    public Button addContactbutton;

    @FXML
    private Button resetButton;

    @FXML
    private Label errorLabel;

    private Person person;



    @FXML
    public void addContact() throws NullPointerException{

        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String street = streetText.getText();
        String city = cityText.getText();
        String postalCode = postalText.getText();
        String phoneNumber = phoneText.getText();

        if(!firstName.isEmpty() && !lastName.isEmpty()) {
            this.person = new Person(firstName, lastName, street, city, postalCode, phoneNumber);
            if(birthdateText.getValue() != null) {
                String birthdate = String.valueOf(birthdateText.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                this.person.setBirthdate(birthdate);
            }
            this.addContactbutton.getScene().getWindow().hide();
        }

        this.errorLabel.setVisible(true);

    }

    @FXML
    public void reset() {
        this.firstNameText.clear();
        this.lastNameText.clear();
        this.streetText.clear();
        this.cityText.clear();
        this.postalText.clear();
        this.birthdateText.getEditor().clear();
        this.phoneText.clear();
    }

    @FXML
    public Button getAddContactButton() {
        return this.addContactbutton;
    }

    public Person getPerson() {
        return this.person;
    }

}
