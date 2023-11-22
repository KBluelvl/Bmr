module com.example.bmrg58137 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens g58137.atlg3.bmr.view to javafx.fxml;
    exports g58137.atlg3.bmr.view;
    exports g58137.atlg3.bmr.model;
    opens g58137.atlg3.bmr.model to javafx.fxml;
    exports g58137.atlg3.bmr.util;
    opens g58137.atlg3.bmr.util to javafx.fxml;
}