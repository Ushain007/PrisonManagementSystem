package com.example.air_plan_customer_service_agent_and_passengers_2222122;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Login {
    @FXML private TextField password;
    @FXML private Button forgetPass;
    @FXML private TextField id;
    @FXML private Button signup_button;
    @FXML private Button signin_button;
    @FXML private CheckBox notRobotBox;

    @FXML
    private void onSignIn(ActionEvent event) {
        String user = id.getText() == null ? "" : id.getText().trim();
        String pass = password.getText() == null ? "" : password.getText().trim();

        if (!Boolean.TRUE.equals(notRobotBox.isSelected())) {
            alert("Please confirm you are not a robot.");
            return;
        }
        if (user.isEmpty() || pass.isEmpty()) {
            alert("ID and Password are required.");
            return;
        }

        // TODO: replace with real auth (DB/API)
        boolean ok = "agent".equalsIgnoreCase(user) && "1234".equals(pass);
        if (ok) {
            // NOTE: file name has a space: "CSADashboard .fxml"
            Navigator.switchTo(event, "CSADashboard .fxml", "Customer Service Dashboard", 1000, 700);
        } else {
            alert("Invalid credentials.");
        }
    }

    @FXML
    private void onForgotPassword(ActionEvent event) {
        alert("Password reset link sent to your registered email (demo).");
    }

    @FXML
    private void onSignUp(ActionEvent event) {
        alert("Sign-up flow not implemented yet (demo).");
    }

    private void alert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}