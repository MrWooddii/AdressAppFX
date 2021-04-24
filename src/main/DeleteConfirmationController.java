package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeleteConfirmationController {

    @FXML
    private Button confirmationButton;

    @FXML
    private Button rejectButton;

    public Button getConfirmationButton() {
        return this.confirmationButton;
    }

    public Button getRejectButton() {
        return this.rejectButton;
    }
}
