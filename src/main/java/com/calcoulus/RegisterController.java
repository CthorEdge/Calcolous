package com.calcoulus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    Account registeredAccount;

//    @FXML
//    private Label registerMessageLabel;
    @FXML
    private TextField usernameEntryRegister;
    @FXML
    private TextField weightEntryRegister;
    @FXML
    private PasswordField passwordEntryRegister;
    @FXML
    private PasswordField passwordConfirmEntryRegister;

    @FXML
    protected void registerButtonClick(ActionEvent event) throws IOException {
        if (passwordConfirmEntryRegister.getText().equals(passwordEntryRegister.getText())){

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

//            registerMessageLabel.setText("Register Successful!");

                // This code is used to change page into Login Page
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else {
//            registerMessageLabel.setText("Register Failed!");
            }
        }
    }
}
