package com.calcoulus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
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
    private ImageView limasatu;
    @FXML
    private ImageView bg;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView Profile;
    @FXML
    private ImageView diaryCalory;
    @FXML
    private ImageView user;
    @FXML
    private ImageView weight;
    @FXML
    private ImageView User_fill;

    @FXML
    protected void initialize(){
        textUsernameMain.setText(mainAccount.getUsername());
        tfWeightMain.setText(String.valueOf(mainAccount.getWeight()));
        calorie_consume.setText(String.valueOf(mainAccount.getCalorieGot()));
        calorie_needs.setText(String.valueOf(mainAccount.getCalorieRequired()));

        File file1 = new File("Image Source/51.png");
        Image image1 = new Image(file1.toURI().toString());
        limasatu.setImage(image1);
        File file2 = new File("Image Source/bg.png");
        Image image2 = new Image(file2.toURI().toString());
        bg.setImage(image2);
        File file3 = new File("Image Source/logout.png");
        Image image3 = new Image(file3.toURI().toString());
        logout.setImage(image3);
        File file4 = new File("Image Source/Profile.png");
        Image image4 = new Image(file4.toURI().toString());
        Profile.setImage(image4);
        File file5 = new File("Image Source/Diary Calorie.png");
        Image image5 = new Image(file5.toURI().toString());
        diaryCalory.setImage(image5);
        File file6 = new File("Image Source/user.png");
        Image image6 = new Image(file6.toURI().toString());
        user.setImage(image6);
        File file7 = new File("Image Source/weight.png");
        Image image7 = new Image(file7.toURI().toString());
        weight.setImage(image7);
        File file8 = new File("Image Source/User_fill.png");
        Image image8 = new Image(file8.toURI().toString());
        User_fill.setImage(image8);
    }

    @FXML
    protected void updateButtonClick(ActionEvent event) throws IOException {
        mainAccount.setWeight(Integer.parseInt(tfWeightMain.getText()));
        database.updateAccountWeight(Integer.parseInt(tfWeightMain.getText()), textUsernameMain.getText());
        mainAccount.setNewCalorieRequired();

        // This code is used to change page into Main Page
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
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
