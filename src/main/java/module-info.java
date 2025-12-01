module com.example.prisonmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.prisonmanagementsystem to javafx.fxml;
    opens com.example.prisonmanagementsystem.Ushain_2320676.Librarian to javafx.fxml, javafx.base;
    opens com.example.prisonmanagementsystem.Ushain_2320676.Warden to javafx.fxml, javafx.base;
    exports com.example.prisonmanagementsystem;
}