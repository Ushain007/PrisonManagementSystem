module com.example.prisonmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prisonmanagementsystem to javafx.fxml;
    exports com.example.prisonmanagementsystem;
}