package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import com.example.prisonmanagementsystem.Ushain_2320676.Book_Model;
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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagementController {

    @FXML
    private TextField authorNameTextField;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
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

    @FXML
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

    private void saveBookToFile(Book_Model newBook) {
        List<Book_Model> bookList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                bookList = (List<Book_Model>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No existing books found, creating new list.");
            }
        }
        bookList.add(newBook);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            e.printStackTrace();
            bookAddedMessageOutput.setText("Error: Could not save to file.");
        }
    }

    private void clearFields() {
        bookTitleTextField.clear();
        authorNameTextField.clear();
        publicationYearTextField.clear();
        quantityTextField.clear();
        bookSectionTextField.clear();
        categoryComboBox.setValue(null);
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrarianDashboardFXML.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}