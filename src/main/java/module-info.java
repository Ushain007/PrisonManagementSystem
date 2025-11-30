module com.example.prisonmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prisonmanagementsystem to javafx.fxml;
    opens com.example.prisonmanagementsystem.Librarian to javafx.fxml, javafx.base;
    opens com.example.prisonmanagementsystem.Warden to javafx.fxml, javafx.base;
    exports com.example.prisonmanagementsystem;
}