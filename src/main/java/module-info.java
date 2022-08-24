module com.example.computationalgeometry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.computationalgeometry to javafx.fxml;
    exports com.example.computationalgeometry;
}