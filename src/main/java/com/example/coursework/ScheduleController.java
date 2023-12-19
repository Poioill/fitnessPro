package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class ScheduleController implements Initializable {

    @FXML
    private TableView<ClassesSchedule> ClassesScheduleTable;

    @FXML
    private TableColumn<ClassesSchedule, String> time;

    @FXML
    private TableColumn<ClassesSchedule, String> Monday;

    @FXML
    private TableColumn<ClassesSchedule, String> Tuesday;

    @FXML
    private TableColumn<ClassesSchedule, String> Wednesday;

    @FXML
    private TableColumn<ClassesSchedule, String> Thursday;

    @FXML
    private TableColumn<ClassesSchedule, String> Friday;

    @FXML
    private TableColumn<ClassesSchedule, String> Saturday;

    @FXML
    private TableColumn<ClassesSchedule, String> Sunday;


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ClassesSchedule classesSchedule = null;

    ObservableList<ClassesSchedule> ClassesScheduleList = FXCollections.observableArrayList();


    @FXML
    void refreshTable() {
        try {
            ClassesScheduleList.clear();

            query = "SELECT * FROM public.classes";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ClassesScheduleList.add(new ClassesSchedule(
                        resultSet.getString("time"),
                        resultSet.getString("Monday"),
                        resultSet.getString("Tuesday"),
                        resultSet.getString("Wednesday"),
                        resultSet.getString("Thursday"),
                        resultSet.getString("Friday"),
                        resultSet.getString("Saturday"),
                        resultSet.getString("Sunday")
                ));
                ClassesScheduleTable.setItems(ClassesScheduleList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDate() {
        connection = DataBaseHandler.getConnect();
        refreshTable();

        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        Monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        Tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        Wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        Thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        Friday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        Saturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
        Sunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();
    }
}
