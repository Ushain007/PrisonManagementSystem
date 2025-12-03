package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewBookDetailsController
{
    @javafx.fxml.FXML
    private Label issuedCopiesLabel;
    @javafx.fxml.FXML
    private ListView borrowerHistoryListView;
    @javafx.fxml.FXML
    private TableColumn availabilityColumn;
    @javafx.fxml.FXML
    private TableView booksTableView;
    @javafx.fxml.FXML
    private TableColumn authorColumn;
    @javafx.fxml.FXML
    private TableColumn bookTitleColumn;
    @javafx.fxml.FXML
    private Label detailIdLabel;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private Label detailAuthorLabel;
    @javafx.fxml.FXML
    private TableColumn categoryColumn;
    @javafx.fxml.FXML
    private Label totalCopiesLabel;
    @javafx.fxml.FXML
    private Label detailTitleLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrarianDashboardFXML.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void searchBookOnAction(ActionEvent actionEvent) {
    }
}