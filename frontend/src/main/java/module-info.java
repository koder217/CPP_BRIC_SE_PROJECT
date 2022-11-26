module edu.cpp.brcm.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires okhttp3;
    requires brcm;
    requires com.fasterxml.jackson.databind;
    opens edu.cpp.brcm.frontend to javafx.fxml;
    exports edu.cpp.brcm.frontend;
}