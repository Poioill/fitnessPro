package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainerScheduleController implements Initializable {

    @FXML
    public TableView<TrainerSchedule> trainerTable;

    @FXML
    private TableColumn<TrainerSchedule, String> time;

    @FXML
    private Label trainerName;

    @FXML
    private TableColumn<TrainerSchedule, String> Monday;

    @FXML
    private TableColumn<TrainerSchedule, String> Tuesday;

    @FXML
    private TableColumn<TrainerSchedule, String> Wednesday;

    @FXML
    private TableColumn<TrainerSchedule, String> Thursday;

    @FXML
    private TableColumn<TrainerSchedule, String> Friday;

    @FXML
    private TableColumn<TrainerSchedule, String> Saturday;

    @FXML
    private TableColumn<TrainerSchedule, String> Sunday;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    TrainerSchedule trainerSchedule = null;

    ObservableList<TrainerSchedule> trainerScheduleList = FXCollections.observableArrayList();

    @FXML
    void refreshTable() {
        try {
            trainerScheduleList.clear();

            query = "SELECT * FROM public.trainer_schedule";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trainerScheduleList.add(new TrainerSchedule(
                        resultSet.getString("s_time"),
                        resultSet.getString("Monday"),
                        resultSet.getString("Tuesday"),
                        resultSet.getString("Wednesday"),
                        resultSet.getString("Thursday"),
                        resultSet.getString("Friday"),
                        resultSet.getString("Saturday"),
                        resultSet.getString("Sunday")

                ));
                trainerTable.setItems(trainerScheduleList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();
    }


    public void initData(String name) {
        trainerName.setText(name);
        System.out.println(trainerName);
    }

    public void loadDate() {
        connection = DataBaseHandler.getConnect();
        refreshTable();

        time.setCellValueFactory(new PropertyValueFactory<>("s_time"));
        Monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        Tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        Wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        Thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        Friday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        Saturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
        Sunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));
    }


}
