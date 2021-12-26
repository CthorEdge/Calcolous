package com.calcoulus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;

public class MainController {
    Account mainAccount = LoginController.loggedAccount;
    Postgres database = new Postgres();
    ArrayList<Food> foodDB = LoginController.foodDB;

    @FXML
    private Text textUsernameMain;
    @FXML
    private TextField tfWeightMain;
    @FXML
    private Text calorie_consume;
    @FXML
    private Text calorie_needs;
    @FXML
    private TextField food_name;
    @FXML
    private TextField grams;

    @FXML
    protected void initialize(){
        textUsernameMain.setText(mainAccount.getUsername());
        tfWeightMain.setText(String.valueOf(mainAccount.getWeight()));
        calorie_consume.setText(String.valueOf(mainAccount.getCalorieGot()));
        calorie_needs.setText(String.valueOf(mainAccount.getCalorieRequired()));
    }

    @FXML
    protected void updateButtonClick(ActionEvent event) throws IOException {
        mainAccount.setWeight(Integer.parseInt(tfWeightMain.getText()));
        database.updateAccountWeight(Integer.parseInt(tfWeightMain.getText()), textUsernameMain.getText());
        mainAccount.setNewCalorieRequired();

        // This code is used to change page into Main Page
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void addButtonClick(ActionEvent event) throws InputMismatchException, IOException {
        mainAccount.setNewCalorieGot(food_name.getText(), Integer.parseInt(grams.getText()),foodDB);

        // This code is used to change page into Main Page
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void resetButtonClick (ActionEvent event) throws IOException {
        mainAccount.setCalorieGot(0);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected  void logoutButtonClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
