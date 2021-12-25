package com.calcoulus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    Account registeredAccount;
    Stage stage;

    @FXML
    private Label registerMessageLabel;
    @FXML
    private TextField usernameEntryRegister;
    @FXML
    private TextField weightEntryRegister;
    @FXML
    private PasswordField passwordEntryRegister;

    public void getPrevStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void registerButtonClick() throws IOException {
        registeredAccount = LoginController.auth.setRegister
                (
                        usernameEntryRegister.getText(),
                        passwordEntryRegister.getText(),
                        Integer.parseInt(weightEntryRegister.getText()),
                        LoginController.database
                );

        if (registeredAccount!=null){

            LoginController.database.insertRegisteredAccount
                    (
                            usernameEntryRegister.getText(),
                            passwordEntryRegister.getText(),
                            Integer.parseInt(weightEntryRegister.getText())
                    );

            registerMessageLabel.setText("Register Successful!");

            // This code is used to change page into Login Page
            FXMLLoader fxmlLoader = new FXMLLoader(CalcoulusApp.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("CALCOULUS");
            stage.setScene(scene);
            stage.show();

        }
        else {
            registerMessageLabel.setText("Register Failed!");
        }
    }

}
