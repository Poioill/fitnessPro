package com.example.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassesWindowController implements Initializable {


    @FXML
    private Label available;

    @FXML
    private Label dateOfWorkout;

    @FXML
    private Label placesWork;

    @FXML
    private Button exitButton;

    @FXML
    private Label room;

    @FXML
    private Label trainer;

    @FXML
    private Label workout;

    @FXML
    public void bookPlace(ActionEvent event) {
        int num = Integer.parseInt(available.getText());
        if (Integer.parseInt(available.getText()) > 0){
            available.setText(Integer.toString(num - 1));
        }
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deletePlace(ActionEvent event) {
        int num = Integer.parseInt(available.getText());
        available.setText(Integer.toString(num + 1));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(String name, String workoutDate) {
        dateOfWorkout.setText(name);
        workout.setText(workoutDate);

    }
}
