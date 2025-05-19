module com.decroly.ejemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.decroly.ejemplojavafx to javafx.fxml;
    exports com.decroly.ejemplojavafx;
}