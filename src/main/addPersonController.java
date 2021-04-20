package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private Button addContactbutton;

    @FXML
    private Button resetButton;

    @FXML
    public void addContact() {

    }

    @FXML
    public void reset() {
        this.firstNameText.clear();
        this.lastNameText.clear();
        this.streetText.clear();
        this.cityText.clear();
        this.postalText.clear();
        this.phoneText.clear();
    }


}
