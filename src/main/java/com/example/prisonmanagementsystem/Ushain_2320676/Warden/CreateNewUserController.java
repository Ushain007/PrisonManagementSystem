package com.example.prisonmanagementsystem.Ushain_2320676.Warden;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateNewUserController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField fullNameTextField;
    @javafx.fxml.FXML
    private ComboBox roleComboBox;
    @javafx.fxml.FXML
    private TextField contactTextField;
    @javafx.fxml.FXML
    private Label generatedUserID;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createNewUserOnAction(ActionEvent actionEvent) {
    }
}