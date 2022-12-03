package edu.cpp.brcm.frontend;

import javafx.scene.control.Alert;

public class ErrorUtil {
    public static void showError(String error){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("Error");
        a.setContentText(error);
        a.show();
    }
}
