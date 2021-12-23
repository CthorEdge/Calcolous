package com.calcoulus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CalcoulusController {
    Postgres database = new Postgres();
    Authenticate auth = new Authenticate();
    Account loggedAccount;

    @FXML
    private Label LoginMessageLabel;
    @FXML
    private TextField usernameEntryLogin;
    @FXML
    private PasswordField passwordEntryLogin;

    @FXML
    protected void loginButtonClick() {
        loggedAccount = auth.setLogin(usernameEntryLogin.getText(), passwordEntryLogin.getText(), database);
        if (loggedAccount!=null){
            System.out.println("Login Successful!");
            LoginMessageLabel.setText("Login Successful!");
        }
        else {
            System.out.println("Login Failed!");
        }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File brandingFile = new File("Image Source/32.png");
//        Image brandingImage = new Image(brandingFile.toURI().toString());
//        brandingImageView.setImage(brandingImage);
//    }

}