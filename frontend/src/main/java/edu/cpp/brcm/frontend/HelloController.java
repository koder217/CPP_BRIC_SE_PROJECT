package edu.cpp.brcm.frontend;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TreeView menuTreeView;

    @FXML
    private Node viewPriceHistory;

    @FXML
    public void initialize(){
        menuTreeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem newVal = (TreeItem) newValue;
            TreeItem oldVal = (TreeItem) oldValue;
            if(Objects.equals(newVal.getValue().toString(), "Price History")){
                System.out.println(newVal.getValue().toString());
                viewPriceHistory.setVisible(true);
            }
        });
    }

    @FXML
    protected void rootTreeItemClicked() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("wooihii");
        a.show();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}