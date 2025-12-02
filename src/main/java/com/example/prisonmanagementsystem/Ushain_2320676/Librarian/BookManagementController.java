package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookManagementController
{
    @javafx.fxml.FXML
    private TextField authorNameTextField;
    @javafx.fxml.FXML
    private ComboBox categoryComboBox;
    @javafx.fxml.FXML
    private Label bookAddedMessageOutput;
    @javafx.fxml.FXML
    private TextField publicationYearTextField;
    @javafx.fxml.FXML
    private TextField bookTitleTextField;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TextField bookSectionTextField;

    private final String FILE_PATH = "Books.bin";

    @FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("Law", "Fiction", "Non-fiction", "History", "Science", "Biography");
    }

    @javafx.fxml.FXML
    public void addNewBookOnAction(ActionEvent actionEvent) {
        if (bookTitleTextField.getText().isEmpty() || authorNameTextField.getText().isEmpty() ||
                categoryComboBox.getValue() == null || publicationYearTextField.getText().isEmpty() ||
                quantityTextField.getText().isEmpty() || bookSectionTextField.getText().isEmpty()) {
            bookAddedMessageOutput.setText("Error: All fields are mandatory.");
            return;
        }

        try {
            int year = Integer.parseInt(publicationYearTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());
            Book_Model newBook = new Book_Model(
                    bookTitleTextField.getText(),
                    authorNameTextField.getText(),
                    categoryComboBox.getValue(),
                    year,
                    quantity,
                    bookSectionTextField.getText()
            );

            saveBookToFile(newBook);
            bookAddedMessageOutput.setText("Success: Book added to Library!");
            clearFields();

        } catch (NumberFormatException e) {
            bookAddedMessageOutput.setText("Error: Year and Quantity must be numbers.");
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) {
    }
}