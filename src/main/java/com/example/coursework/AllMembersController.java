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

public class AllMembersController implements Initializable {

    @FXML
    private TableView<Members> AllMembersTable;

    @FXML
    private TableColumn<Members, String> end_ab;

    @FXML
    private TableColumn<Members, String> start_ab;

    @FXML
    private TableColumn<Members, String> membership;

    @FXML
    private TableColumn<Members, String> trainer;

    @FXML
    private TableColumn<Members, String> group_member;

    @FXML
    private TableColumn<Members, String> contact;

    @FXML
    private TableColumn<Members, String> name;

    @FXML
    private TableColumn<Members, String> id;


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Members members = null;

    ObservableList<Members> MembersList = FXCollections.observableArrayList();

    @FXML
    void refreshTable() {
        try {
            MembersList.clear();

            query = "SELECT * FROM public.members";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MembersList.add(new Members(
                        resultSet.getInt("id_member"),
                        resultSet.getString("name"),
                        resultSet.getString("contact"),
                        resultSet.getString("group_member"),
                        resultSet.getString("membership"),
                        resultSet.getString("trainer"),
                        resultSet.getDate("start_ab"),
                        resultSet.getDate("end_ab")
                ));
                AllMembersTable.setItems(MembersList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDate() {
        connection = DataBaseHandler.getConnect();
        refreshTable();

        id.setCellValueFactory(new PropertyValueFactory<>("id_member"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        trainer.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        end_ab.setCellValueFactory(new PropertyValueFactory<>("end_ab"));
        start_ab.setCellValueFactory(new PropertyValueFactory<>("start_ab"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        group_member.setCellValueFactory(new PropertyValueFactory<>("group_member"));
        membership.setCellValueFactory(new PropertyValueFactory<>("membership"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();
    }
}
