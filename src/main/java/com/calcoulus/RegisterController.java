package com.calcoulus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    Account registeredAccount;

    @FXML
    private TextField usernameEntryRegister;
    @FXML
    private TextField weightEntryRegister;
    @FXML
    private PasswordField passwordEntryRegister;
    @FXML
    private PasswordField passwordConfirmEntryRegister;
    @FXML
    private ImageView frame2;
    @FXML
    private  ImageView sayur;
    @FXML
    private ImageView c;
    @FXML
    private ImageView enam;

    @FXML
    protected void initialize(){
        File file1 = new File("Image Source/frame2.png");
        Image image1 = new Image(file1.toURI().toString());
        frame2.setImage(image1);

        File file2 = new File("Image Source/sayur.png");
        Image image2 = new Image(file2.toURI().toString());
        sayur.setImage(image2);

        File file3 = new File("Image Source/c.png");
        Image image3 = new Image(file3.toURI().toString());
        c.setImage(image3);

        File file4 = new File("Image Source/6.png");
        Image image4 = new Image(file4.toURI().toString());
        enam.setImage(image4);
    }

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
    @FXML
    public void backButtonClick(ActionEvent event) throws IOException {
        // This code is used to change page into Login Page
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
