module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.calculator.View;

    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
}