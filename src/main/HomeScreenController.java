package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Button deletebutton;

    @FXML
    private Button editButton;

    @FXML
    private Button addButton;



    private ObservableList<Person> personData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personData.add(new Person("Steve", "Holzapfel", "Unterdorfstraße 2", "Meckenheim", "53340", "24.03.1995", "12356766"));
        personData.add(new Person("Kerstin", "Holzapfel", "Unterdorfstraße 2", "Meckenheim", "53340", "18.07.1956", "4598455"));
        personData.add(new Person("Helmut", "Holzapfel", "Unterdorfstraße 3", "Meckenheim", "53340", "20.08.1965", "459856"));
        personData.add(new Person("Rebecca", "Frings", "Am Zehnthof 38", "Koblenz", "34567", "21.10.1975", "123688"));
        personData.add(new Person("Hansi", "Flick", "Am Zehnthof 38", "Frankfurt", "1123123", "05.05.1945", "569568"));
        personData.add(new Person("Knorkator", "Hans"));

        firstName.setCellValueFactory(new PropertyValueFactory<Person, String> ("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Person, String> ("lastName"));
        table.setItems(this.personData);
    }

    @FXML
    public void clickName(MouseEvent event) {

        try {
            //get the table position of the clicked row and the index
            TablePosition pos = (TablePosition) table.getSelectionModel().getSelectedCells().get(0);
            int index = pos.getRow();

            //change every label to the known data
            this.firstNameLabel.setText(personData.get(index).getFirstName());
            this.lastNameLabel.setText(personData.get(index).getLastName());
            this.streetLabel.setText(personData.get(index).getStreet());
            this.cityLabel.setText(personData.get(index).getCity());
            this.postalLabel.setText(personData.get(index).getPostalCode());
            this.birthdayLabel.setText(personData.get(index).getBirthdate());
            this.phoneNumberLabel.setText(personData.get(index).getPhoneNumber());

            //String selected = firstName.getCellObservableValue(index).getValue();
            //String selected = table.getItems().get(index).;
            // test : System.out.println(selected);
        } catch (Exception e) {
            System.out.println("Empty column selected");
        }
    }

    @FXML
    public void addPerson() throws IOException {
        addPersonController addPersonController = new addPersonController();

        Parent root = FXMLLoader.load(getClass().getResource("addPerson.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


        if(addPersonController.getPerson() != null) {
            addPersonController.addContact();
            this.personData.add(addPersonController.getPerson());
            this.table.setItems(this.personData);
            this.table.refresh();
        }

    }

}
