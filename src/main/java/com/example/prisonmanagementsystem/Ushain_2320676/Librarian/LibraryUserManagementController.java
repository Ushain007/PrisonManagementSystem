package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import com.example.prisonmanagementsystem.AppendableObjectOutputStream; // Ensure this matches your file location

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LibraryUserManagementController {

    @FXML private Label newLibraryMemberOutput;
    @FXML private ComboBox<String> newUserTypeComboBox;
    @FXML private TextField newUserContactNumber;
    @FXML private TextField newUserIDTextField;
    @FXML private TextField libraryNewUserNameTextField;

    // File Paths for Binary Storage
    private final String LIBRARIAN_FILE = "LibrianData.bin";
    private final String MEMBER_FILE = "MemberData.bin";

    @FXML
    public void initialize() {
        // 1. Populate the ComboBox
        newUserTypeComboBox.getItems().addAll("Librian", "Member");
    }

    // --- EVENT HANDLER: Create Button Clicked ---
    @FXML
    public void createNewLibraryMemberOnAction(ActionEvent actionEvent) {
        // 1. Get Data from TextFields
        String name = libraryNewUserNameTextField.getText();
        String contact = newUserContactNumber.getText();
        String type = newUserTypeComboBox.getValue();
        String idStr = newUserIDTextField.getText();

        // 2. Validation
        if (name.isEmpty() || contact.isEmpty() || type == null || idStr.isEmpty()) {
            newLibraryMemberOutput.setText("Error: All fields are mandatory.");
            newLibraryMemberOutput.setStyle("-fx-text-fill: red;");
            return;
        }

        // 3. Parse ID (Manual Input)
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            newLibraryMemberOutput.setText("Error: ID must be a number.");
            newLibraryMemberOutput.setStyle("-fx-text-fill: red;");
            return;
        }

        // 4. Create Object & Save
        if (type.equals("Librian")) {
            // Create Librarian Model
            Librarian_Model newLib = new Librarian_Model(id, name, "N/A", contact, "1234", "N/A", null);
            saveLibrarianToFile(newLib);
        }
        else if (type.equals("Member")) {
            // Create Member Model
            LibraryMember_Model newMem = new LibraryMember_Model(id, name, "N/A", contact, "Prisoner", "Standard");
            saveMemberToFile(newMem);
        }

        // 5. Feedback & Cleanup
        newLibraryMemberOutput.setText("Success: " + type + " registered!");
        newLibraryMemberOutput.setStyle("-fx-text-fill: green;");
        clearFields();
    }

    // --- HELPER: Save Librarian ---
    private void saveLibrarianToFile(Librarian_Model lib) {
        File f = new File(LIBRARIAN_FILE);
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists() && f.length() > 0) {
                fos = new FileOutputStream(f, true); // Append mode
                oos = new AppendableObjectOutputStream(fos); // Use helper to skip header
            } else {
                fos = new FileOutputStream(f); // Create new
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(lib);
            oos.close();

        } catch (IOException e) {
            newLibraryMemberOutput.setText("Error saving: " + e.getMessage());
        }
    }

    // --- HELPER: Save Member ---
    private void saveMemberToFile(LibraryMember_Model mem) {
        File f = new File(MEMBER_FILE);
        try {
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists() && f.length() > 0) {
                fos = new FileOutputStream(f, true); // Append mode
                oos = new AppendableObjectOutputStream(fos); // Use helper to skip header
            } else {
                fos = new FileOutputStream(f); // Create new
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(mem);
            oos.close();

        } catch (IOException e) {
            newLibraryMemberOutput.setText("Error saving: " + e.getMessage());
        }
    }

    private void clearFields() {
        libraryNewUserNameTextField.clear();
        newUserContactNumber.clear();
        newUserIDTextField.clear();
        newUserTypeComboBox.setValue(null);
    }

    // --- NAVIGATION ---
    @FXML
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrarianDashboardFXML.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Unused methods
    @FXML public void newUserTypeComboBox(ActionEvent actionEvent) {}
    @FXML public void newUserContactNumber(ActionEvent actionEvent) {}
    @FXML public void newUserIDTextField(ActionEvent actionEvent) {}
    @FXML public void libraryNewUserNameTextField(ActionEvent actionEvent) {}
}