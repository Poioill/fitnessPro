package com.example.coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        TreeItem<String> rootItemMembers = new TreeItem<>("Members", new ImageView(new Image(getClass().getResourceAsStream("person.png"))));
        TreeItem<String> rootItemStaff = new TreeItem<>("Staff");
        TreeItem<String> rootItemChat = new TreeItem<>("Chat");
        TreeItem<String> rootItemSchedule = new TreeItem<>("Schedule");
        TreeItem<String> rootItemPayments = new TreeItem<>("Payments");
        TreeItem<String> rootItemPrice = new TreeItem<>("Price");

        TreeItem<String> itemMembersAll = new TreeItem<>("All members");
        TreeItem<String> itemMembersAdd = new TreeItem<>("Add a member");
        TreeItem<String> itemMembersProfile = new TreeItem<>("Member's profile");

        TreeItem<String> itemScheduleClass = new TreeItem<>("Classes");
        TreeItem<String> itemSchedulePersonal = new TreeItem<>("Personal classes");

        menuRoot.getChildren().addAll(rootItemHome,rootItemMembers,rootItemStaff, rootItemChat,  rootItemSchedule, rootItemPayments,  rootItemPrice);
        rootItemMembers.getChildren().addAll(itemMembersAll, itemMembersAdd, itemMembersProfile);
        rootItemSchedule.getChildren().addAll(itemScheduleClass, itemSchedulePersonal);

        menu.setShowRoot(false);
        menu.setRoot(menuRoot);
    }

    public void treeMenu() {
        TreeItem<String> item = (TreeItem<String>) menu.getSelectionModel().getSelectedItem();
        if (item != null){
            System.out.printf(item.getValue());
        }
    }

    public void exit(ActionEvent event) {
    }
}
