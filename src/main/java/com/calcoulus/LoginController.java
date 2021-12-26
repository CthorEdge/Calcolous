package com.calcoulus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LoginController{
    static Postgres database = new Postgres();
    static Authenticate auth = new Authenticate();

    static ArrayList<Food> foodDB = new ArrayList<>();

    public static Account loggedAccount;

    @FXML
    private Label LoginMessageLabel;
    @FXML
    private TextField usernameEntryLogin;
    @FXML
    private PasswordField passwordEntryLogin;

    @FXML
    protected void initialize(){
        database.reloadFoodDB(foodDB);
    }

    @FXML
    protected void loginButtonClick(ActionEvent event) throws IOException {

        loggedAccount = auth.setLogin(usernameEntryLogin.getText(), passwordEntryLogin.getText(), database);
        if (loggedAccount != null) {

            loggedAccount = database.reloadRegisteredAccount(usernameEntryLogin.getText());
            LoginMessageLabel.setText("Login Successful!");

            // This code is used to change page into Main Page
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("Login Failed!");
        }
    }

    @FXML
    protected void registerNowClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}