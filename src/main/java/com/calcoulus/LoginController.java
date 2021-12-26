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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
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
    private ImageView loginLogo;
    @FXML
    private ImageView bg1Login;
    @FXML
    private ImageView bg2Login;

    @FXML
    protected void initialize(){
        File file1 = new File("Image Source/32.png");
        Image image1 = new Image(file1.toURI().toString());
        loginLogo.setImage(image1);

        File file2 = new File("Image Source/3.3.png");
        Image image2 = new Image(file2.toURI().toString());
        bg1Login.setImage(image2);

        File file3 = new File("Image Source/5.png");
        Image image3 = new Image(file3.toURI().toString());
        bg2Login.setImage(image3);

        database.reloadFoodDB(foodDB);
    }

    @FXML
    protected void loginButtonClick(ActionEvent event) throws IOException {

        loggedAccount = auth.setLogin(usernameEntryLogin.getText(), passwordEntryLogin.getText(), database);
        if (loggedAccount != null) {

            loggedAccount = database.reloadRegisteredAccount(usernameEntryLogin.getText());
            LoginMessageLabel.setText("Login Successful!");

            // This code is used to change page into Main Page
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
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