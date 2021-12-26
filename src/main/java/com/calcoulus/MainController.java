package com.calcoulus;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    Account mainAccount = LoginController.loggedAccount;

    @FXML
    private TextField tfUsernameMain;
    @FXML
    private TextField tfWeightMain;

    public MainController(){
        setTfUsernameMain(mainAccount.getUsername());
        setTfWeightMain(String.valueOf(mainAccount.getWeight()));
    }

    public void setTfUsernameMain(String data) {
        tfUsernameMain.setText(data);
    }
    public void setTfWeightMain(String data) {
        tfWeightMain.setText(data);
    }
}
