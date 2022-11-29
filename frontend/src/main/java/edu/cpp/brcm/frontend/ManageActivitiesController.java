package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Objects;

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
    private TableView.TableViewSelectionModel<ActivityDto> selectionModel;
    @FXML
    private void initialize(){
        btnAddNewActivity.setOnAction(this::btnAddNewActivity_Clicked);
        btnRefreshActivities.setOnAction(this::btnRefreshActivities_Clicked);
        btnSaveChanges.setOnAction(this::btnSaveChanges_Clicked);
        tableActivities.setPlaceholder(
                new Label("No activities to display! Try adding one!"));

        TableColumn<ActivityDto, Integer> columnId =
                new TableColumn<>("Id");
        columnId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<ActivityDto, String> column1 =
                new TableColumn<>("Name");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<ActivityDto, String> column2 =
                new TableColumn<>("Price");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        TableColumn<ActivityDto, Button> column3 =
                new TableColumn<>("Delete");
        column3.setCellFactory(DeleteButtonTableCell.<ActivityDto>forTableColumn("Remove", (ActivityDto p) -> {
            deleteActivity(p);
            return p;
        }));
        tableActivities.getColumns().add(columnId);
        tableActivities.getColumns().add(column1);
        tableActivities.getColumns().add(column2);
        tableActivities.getColumns().add(column3);
        selectionModel = tableActivities.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        refreshGrid();
        selectionModel.select(0);
        ObservableList<ActivityDto> selectedItems =
                selectionModel.getSelectedItems();

        selectedItems.addListener(
                new ListChangeListener<ActivityDto>() {
                    @Override
                    public void onChanged(
                            Change<? extends ActivityDto> change) {
                        var ol = change.getList();
                        if (ol.size() > 0) {
                            ActivityDto ad = change.getList().get(0);
                            lblActivityId.setText(ad.getId().toString());
                            txtActivityName.setText(ad.getName());
                            txtActivityPrice.setText(ad.getPrice().toString());
                        }
                    }
                });
    }

    @FXML
    private void btnAddNewActivity_Clicked(ActionEvent e){
        lblActivityId.setText("New");
        txtActivityName.setText("");
        txtActivityPrice.setText("");
    }
    @FXML
    private void btnRefreshActivities_Clicked(ActionEvent e){
        refreshGrid();
    }
    private void deleteActivity(ActivityDto d){
        try {
            BrcmAPI.DeleteRequest(BrcmAPI.ActivitiesUrl+d.getId().toString());
            refreshGrid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void refreshGrid(){
        var dto = BrcmAPI.GetRequest(BrcmAPI.ActivitiesUrl, ActivityDto[].class);
        if(dto != null){
            System.out.println(dto.length);
            tableActivities.getItems().clear();
            for (var d: dto){
                tableActivities.getItems().add(d);
            }
            selectionModel.select(0);
        }
    }
    @FXML
    private void btnSaveChanges_Clicked(ActionEvent e){
        try {
            var actId = lblActivityId.getText();
            var name= txtActivityName.getText();
            var price= Double.parseDouble(txtActivityPrice.getText());
            if(Objects.equals(actId, "New") || Objects.equals(actId, "") || Objects.equals(actId, null)){
                var dto = new ActivityDto(0,name,price);
                ActivityDto result = BrcmAPI.PostRequest(BrcmAPI.ActivitiesUrl, dto, ActivityDto.class);
            } else {
                var dto = new ActivityDto(Integer.parseInt(actId),name,price);
                BrcmAPI.PutRequest(BrcmAPI.ActivitiesUrl+actId, dto);
            }
            refreshGrid();
        }
        catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
