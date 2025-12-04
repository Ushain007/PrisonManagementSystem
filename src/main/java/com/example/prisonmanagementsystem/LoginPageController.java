package com.example.prisonmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LoginPageController {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField passwordTextField;

    ObservableList<User> wardenList = FXCollections.observableArrayList();
    ObservableList<User> librarianList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        User wardenAccount = new User(
                "0001",
                "Ushain Marma Ishan",
                "ushain.warden@prison.com",
                "01406927098",
                "Admin Block",
                "Male",
                "1234",
                LocalDate.of(2000, 1, 1)
        );
        wardenList.add(wardenAccount);

        User librarianAccount = new User(
                "0002",
                "Librarian Name",
                "librarian.email@prison.com",
                "01786259239",
                "Library Block",
                "Female",
                "1234",
                LocalDate.of(1995, 5, 20)
        );
        librarianList.add(librarianAccount);
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String id = idTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        if (id.isEmpty() || password.isEmpty()) {
            showAlert("Login Error", "Please enter both ID and Password.");
            return;
        }

        for (User u : wardenList) {
            if (u.getId().equals(id) && u.getPassword().equals(password)) {
                loadDashboard(actionEvent,"Warden Dashboard","/com/example/prisonmanagementsystem/Ushain_2320676/Warden/WardenDashboardFXML.fxml");
                return;
            }
        }

        for (User u : librarianList) {
            if (u.getId().equals(id) && u.getPassword().equals(password)) {
                loadDashboard(actionEvent,"Librarian Dashboard","/com/example/prisonmanagementsystem/Ushain_2320676/Librarian/LibrarianDashboardFXML.fxml");
                return;
            }
        }

        showAlert("Login Failed", "Invalid Credentials. Check ID and Password properly.");
    }

    private void loadDashboard(ActionEvent event, String title, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("System Error", "Could not load dashboard.\nPath: " + fxmlPath);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}