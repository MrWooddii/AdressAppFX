package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeleteConfirmationController {

    @FXML
    private Button confirmationButton;

    @FXML
    private Button rejectButton;

    private boolean confirm = false;


    public boolean getConfirm() {
        return this.confirm;
    }

    public void setConfirm(boolean bool) {
        this.confirm = bool;
    }

    public Button getConfirmationButton() {
        return this.confirmationButton;
    }

    public Button getRejectButton() {
        return this.rejectButton;
    }
}
