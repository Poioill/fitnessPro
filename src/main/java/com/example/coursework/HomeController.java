package com.example.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private TreeView menu;
    @FXML
    private Button exitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> menuRoot = new TreeItem<>("root");

        TreeItem<String> rootItemHome = new TreeItem<>("Home", new ImageView(new Image(getClass().getResourceAsStream("home.png"))));
        TreeItem<String> rootItemMembers = new TreeItem<>("Members", new ImageView(new Image(getClass().getResourceAsStream("members.png"))));
        TreeItem<String> rootItemStaff = new TreeItem<>("Staff", new ImageView(new Image(getClass().getResourceAsStream("staff.png"))));
        TreeItem<String> rootItemChat = new TreeItem<>("Chat", new ImageView(new Image(getClass().getResourceAsStream("chat.png"))));
        TreeItem<String> rootItemSchedule = new TreeItem<>("Schedule", new ImageView(new Image(getClass().getResourceAsStream("schedule.png"))));
        TreeItem<String> rootItemPayments = new TreeItem<>("Payments", new ImageView(new Image(getClass().getResourceAsStream("payments.png"))));
        TreeItem<String> rootItemPrice = new TreeItem<>("Price", new ImageView(new Image(getClass().getResourceAsStream("price.png"))));

        TreeItem<String> itemMembersAll = new TreeItem<>("All members", new ImageView(new Image(getClass().getResourceAsStream("person.png"))));
        TreeItem<String> itemMembersAdd = new TreeItem<>("Add a member", new ImageView(new Image(getClass().getResourceAsStream("person_add.png"))));
        TreeItem<String> itemMembersProfile = new TreeItem<>("Member's profile", new ImageView(new Image(getClass().getResourceAsStream("person.png"))));

        TreeItem<String> itemScheduleClass = new TreeItem<>("Classes", new ImageView(new Image(getClass().getResourceAsStream("classes.png"))));
        TreeItem<String> itemSchedulePersonal = new TreeItem<>("Personal classes", new ImageView(new Image(getClass().getResourceAsStream("personalClasses.png"))));

        menuRoot.getChildren().addAll(rootItemHome, rootItemMembers, rootItemStaff, rootItemChat, rootItemSchedule, rootItemPayments, rootItemPrice);
        rootItemMembers.getChildren().addAll(itemMembersAll, itemMembersAdd, itemMembersProfile);
        rootItemSchedule.getChildren().addAll(itemScheduleClass, itemSchedulePersonal);

        menu.setShowRoot(false);
        menu.setRoot(menuRoot);
    }

    public void treeMenu() {
        TreeItem<String> item = (TreeItem<String>) menu.getSelectionModel().getSelectedItem();
        if (item != null) {
            System.out.printf(item.getValue());
        }
    }

    public void exit(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
