module himal.lab5tipcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens himal.lab5tipcalculator to javafx.fxml;
    exports himal.lab5tipcalculator;
}