package com.example.air_plan_customer_service_agent_and_passengers_2222122;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {

    public static void switchTo(ActionEvent event, String fxmlResource, String title, double w, double h) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxmlResource));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, w, h));
            if (title != null) stage.setTitle(title);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            // optional: show an Alert here
        }
    }
}