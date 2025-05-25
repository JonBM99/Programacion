module com.decroly.pruebaexamenfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.decroly.pruebaexamenfinal to javafx.fxml;
    exports com.decroly.pruebaexamenfinal;
}