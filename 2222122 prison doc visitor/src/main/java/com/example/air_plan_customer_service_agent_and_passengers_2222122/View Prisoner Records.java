package com.example.air_plan_customer_service_agent_and_passengers_2222122;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import javax.swing.text.TableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class ViewPrisonerRecords implements Initializable {
    @Deprecated
    private void handleDashboardButton(ActionEvent event) throws IOException {
        // Load the new FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Parent root = loader.load();

        // Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void initialize() {
        groupBoxCSA.getItems().addAll("A", "C", "B");
        groupBoxCSA.setValue("Option 1"); // default selection
    }
    @FXML
    private Button reschedule;
    @FXML
    private Button cancel;
    @FXML
    private TableColumn SeatNumberTable;
    @FXML
    private Button medicalNeeds;
    @FXML
    private ChoiceBox AssistanceServices;



    @FXML
    private ChoiceBox<String> groupBoxCSA;
    @FXML
    private TableColumn groupNameTable;
    @FXML
    private Button DashboardCSA;


    @FXML
    private Button CustomerServiceAgentInfoEdit;

    @FXML
    private TableColumn<?, ?> DueTable;

    @FXML
    private Button Passengers;

    @FXML
    private Button Track;

    @FXML
    private Button bookingBack;

    @FXML
    private Button bookingNext;






    @FXML
    private Button print;

    @FXML
    private TableView tableGroupPassengers;

    @FXML
    private TableColumn<?, ?> timeTable;

}
