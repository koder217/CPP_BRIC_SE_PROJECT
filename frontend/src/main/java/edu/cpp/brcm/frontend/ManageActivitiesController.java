package edu.cpp.brcm.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageActivitiesController {
    @FXML
    private Button btnAddNewActivity;
    @FXML
    private Button btnRefreshActivities;
    @FXML
    private Button btnSaveChanges;
    @FXML
    private Label lblActivityId;
    @FXML
    private TextField txtActivityName;
    @FXML
    private TextField txtActivityPrice;
    @FXML
    private TableView tableActivities;
    @FXML
    private void initialize(){
        
    }
}
