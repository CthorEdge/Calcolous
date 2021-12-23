module com.calcoulus.calcoulus {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.calcoulus to javafx.fxml;
    exports com.calcoulus;
}