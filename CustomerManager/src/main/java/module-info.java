module com.customermanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.customermanager to javafx.fxml;
    opens com.customermanager.controller to javafx.fxml;
    opens com.customermanager.model to javafx.base;

    exports com.customermanager;
}