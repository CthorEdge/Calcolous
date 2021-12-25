package com.calcoulus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController{
    static Postgres database = new Postgres();
    static Authenticate auth = new Authenticate();

    Account loggedAccount;
    Stage stage;
    Scene scene;

    public void getPrevStage(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    @FXML
    private Label LoginMessageLabel;
    @FXML
    private TextField usernameEntryLogin;
    @FXML
    private PasswordField passwordEntryLogin;

    @FXML
    protected void loginButtonClick() throws IOException  {

        loggedAccount = auth.setLogin(usernameEntryLogin.getText(), passwordEntryLogin.getText(), database);
        if (loggedAccount!=null){

            loggedAccount = database.reloadRegisteredAccount(usernameEntryLogin.getText());
            LoginMessageLabel.setText("Login Successful!");

            // This code is used to change page into Main Page

            FXMLLoader fxmlLoader = new FXMLLoader(CalcoulusApp.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("CALCOULUS");
            stage.setScene(scene);
            stage.show();

            RegisterController rc = new RegisterController();
            rc.getPrevStage(stage);

        }
        else {
            System.out.println("Login Failed!");
        }
    }
}