module com.lasalle.hadivina.adivina {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.lasalle.hadivina.adivina to javafx.fxml;
    exports com.lasalle.hadivina.adivina;
}