package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Label usernameEmptyLabel;

    @FXML
    private Label passwordEmptyLabel;

    @FXML
    private Label loginFailedLabel;

    @FXML
    private PasswordField passwordField;


    @FXML
    public void login(ActionEvent event) throws IOException {

        //checks if either username is empty or password is empty
        boolean usernameEmpty = this.usernameTextField.getText().isEmpty();
        boolean passwordEmpty = this.passwordField.getText().isEmpty();

        if(usernameEmpty || passwordEmpty) {

            this.loginFailedLabel.setVisible(false);

            if(usernameEmpty) {
                this.usernameEmptyLabel.setVisible(true);
            } else {
                this.usernameEmptyLabel.setVisible(false);
            }

            if(passwordEmpty) {
                this.passwordEmptyLabel.setVisible(true);
            } else {
                this.passwordEmptyLabel.setVisible(false);
            }

            this.usernameTextField.clear();
            this.passwordField.clear();
            return;
        }

        this.usernameEmptyLabel.setVisible(false);
        this.passwordEmptyLabel.setVisible(false);

        //TODO: Für Testzwecke Username: Wooddii ; Passwort: 123 ; zukünftig abfrage erstellen

        if(this.usernameTextField.getText().equals("Wooddii") && this.passwordField.getText().equals("123")) {
            this.loginFailedLabel.setVisible(false);
            System.out.println("success");
        } else {
            this.loginFailedLabel.setVisible(true);
        }

        //get username
        String username = usernameTextField.getText();

        //get FXMLLoader of homeScreen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeScreen.fxml"));
        root = loader.load();

        //instantiate homeScreenController to display given username
        HomeScreenController homeScreenController = loader.getController();
        //homeScreenController.displayName(username);

        //switch scenes to Home Screen
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();      //event = button click -> Source des Klicks erhalten -> Scene des Buttons erhalten (in Main = "primaryStage.setScene...") -> Window erhalten
        stage.setTitle("Address app by " + username);
        scene = new Scene(root);                                                //in die erhaltene Scene die zuvor geladene root einfügen
        stage.setScene(scene);
        stage.show();

    }
}
