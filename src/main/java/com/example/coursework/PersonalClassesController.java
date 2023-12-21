package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalClassesController implements Initializable {

    @FXML
    private TableView<PersonalClasses> PersonalTable;

    @FXML
    private TableColumn<PersonalClasses, String> name;

    @FXML
    private TableColumn<PersonalClasses, String> job;

    @FXML
    private TableColumn<PersonalClasses, String> number;

    @FXML
    private TableColumn<PersonalClasses, PersonalClasses> id_schedule;

    @FXML
    TableColumn<PersonalClasses, String> id_trainer;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    PersonalClasses personalClasses = null;


    ObservableList<PersonalClasses> PersonalClassesList = FXCollections.observableArrayList();

    @FXML
    void refreshTable() {
        try {
            PersonalClassesList.clear();

            query = "SELECT * FROM public.trainers";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PersonalClassesList.add(new PersonalClasses(
                        resultSet.getInt("id_trainer"),
                        resultSet.getString("trainer_name"),
                        resultSet.getString("tr_number"),
                        resultSet.getString("tr_job"),
                        resultSet.getInt("id_schedule")

                ));
                PersonalTable.setItems(PersonalClassesList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDate() {
        connection = DataBaseHandler.getConnect();
        refreshTable();

        number.setCellValueFactory(new PropertyValueFactory<>("tr_number"));
        name.setCellValueFactory(new PropertyValueFactory<>("trainer_name"));
        job.setCellValueFactory(new PropertyValueFactory<>("tr_job"));
        id_schedule.setCellValueFactory(new PropertyValueFactory<>("id_schedule"));
        id_trainer.setCellValueFactory(new PropertyValueFactory<>("id_trainer"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();

        PersonalTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                PersonalClasses selectedPerson = PersonalTable.getSelectionModel().getSelectedItem();

                if (selectedPerson != null) {
                    openDetailsWindow(name, id_trainer);
                }
            }
        });
    }

    private void openDetailsWindow(TableColumn<PersonalClasses, String> name, TableColumn<PersonalClasses, String> id_trainer) {
        try {
            Stage stageNew = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("trainerSchedule.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1275, 660);

            // передаем данные
            TrainerScheduleController detailsController = fxmlLoader.getController();
            PersonalClasses selectedPerson = PersonalTable.getSelectionModel().getSelectedItem();
            if (selectedPerson != null) {
                detailsController.initData(selectedPerson.getTrainer_name());
            }

            String css = this.getClass().getResource("base.css").toExternalForm();
            scene.getStylesheets().add(css);

            stageNew.setScene(scene);
            stageNew.show();
        } catch (IOException ex) {
            Logger.getLogger(PersonalClassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

