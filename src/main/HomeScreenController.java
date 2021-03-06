package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
        //Test data to populate the table view
        personData.add(new Person("Max", "Mustermann", "Musterstraße 1", "Musterstadt", "01.01.2000", "12345", "123456678"));
        personData.add(new Person("Erika", "Mustermann"));

        firstName.setCellValueFactory(new PropertyValueFactory<Person, String> ("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Person, String> ("lastName"));
        table.setItems(this.personData);
    }

    @FXML
    public void addPerson() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addPerson.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        AddPersonController addPersonController = loader.getController();

        addPersonController.getAddContactButton().setOnAction(actionEvent -> {
            addPersonController.addContact();
            if(addPersonController.getPerson() == null) {
                return;
            }

            //add the new Person to the personData - List
            this.personData.add(addPersonController.getPerson());
            this.table.refresh();
        });
    }

    @FXML
    public void confirmDelete() throws IOException{

        try {
            int index = getTablePosition();
        } catch (Exception e) {
            System.out.println("No person selected");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteConfirmation.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        DeleteConfirmationController deleteConfirmationController = loader.getController();


        deleteConfirmationController.getConfirmationButton().setOnAction(actionEvent -> {
            delete();
            scene.getWindow().hide();
        });

        deleteConfirmationController.getRejectButton().setOnAction(actionEvent -> {
            scene.getWindow().hide();
        });

    }

    @FXML
    public void delete() {
        int index = getTablePosition();

        this.personData.remove(index);
        setPersonDetails();
    }

    @FXML
    public void editPerson() throws IOException {

        try {
            int index = getTablePosition();
            Person person = this.personData.get(index);

            //only show stage if a person exists
            if(person != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("editPerson.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);

                EditPersonController editPersonController = loader.getController();

                stage.show();

                //TextFields are getting filled with the current data
                editPersonController.setTextField(person);

                //change contact details with click on "Edit Contact"
                editPersonController.getEditContactButton().setOnAction(actionEvent -> {
                    editPersonController.editContact(person);
                    this.personData.set(index, person);
                    this.table.refresh();
                    setPersonDetails();
                });

            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Empty row selected");
        }
    }

    @FXML
    public void setPersonDetails() {

        try {
            //get the index of the selected Person in the table view
            int index = getTablePosition();

            //change every label to the known data
            this.firstNameLabel.setText(personData.get(index).getFirstName());
            this.lastNameLabel.setText(personData.get(index).getLastName());
            this.streetLabel.setText(personData.get(index).getStreet());
            this.cityLabel.setText(personData.get(index).getCity());
            this.postalLabel.setText(personData.get(index).getPostalCode());
            this.birthdayLabel.setText(personData.get(index).getBirthdate());
            this.phoneNumberLabel.setText(personData.get(index).getPhoneNumber());

        } catch (Exception e) {
            System.out.println("Empty column selected");
        }
    }

    //get the index of the selected Person in the table view
    private Integer getTablePosition() {
        TablePosition pos = (TablePosition) table.getSelectionModel().getSelectedCells().get(0);
        int index = pos.getRow();
        return index;
    }
}
