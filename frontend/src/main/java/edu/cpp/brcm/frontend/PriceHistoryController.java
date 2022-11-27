package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.dtos.HistoricalpriceDto;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PriceHistoryController {
    @FXML
    private ChoiceBox choiceActivities;
    @FXML
    private TableView tableActivities;
    @FXML
    private Button btnRefreshActivities;
    private void refreshGrid(Integer activityId){
        var dto= BrcmAPI.GetRequest(BrcmAPI.PriceHistoryUrl+activityId, HistoricalpriceDto[].class);
        if(dto != null){
            System.out.println("price history count:"+dto.length);
            tableActivities.getItems().clear();
            for (var d: dto){
                tableActivities.getItems().add(d);
            }
        }
    }
    private ActivityDto[] activityDtos;
    @FXML
    public void initialize(){
        btnRefreshActivities.setOnAction(this::btnRefreshActivities_Clicked);
        populateDropdown();
        choiceActivities.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println(choiceActivities.getItems().get((Integer) number2));
                var selection = choiceActivities.getItems().get((Integer) number2);
                Integer activityId = 0;
                for(ActivityDto activityDto:activityDtos){
                    if(activityDto.getName()==selection){
                        activityId = activityDto.getId();
                    }
                }
                refreshGrid(activityId);
            }
        });
        tableActivities.setPlaceholder(
                new Label("No historical price data to display. Try selecting an activity above!"));

        TableColumn<HistoricalpriceDto, Integer> columnId =
                new TableColumn<>("Id");
        columnId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<HistoricalpriceDto, String> column1 =
                new TableColumn<>("Date");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("date"));

        TableColumn<HistoricalpriceDto, String> column2 =
                new TableColumn<>("Price");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("price"));

        tableActivities.getColumns().add(columnId);
        tableActivities.getColumns().add(column1);
        tableActivities.getColumns().add(column2);

    }

    private void populateDropdown() {
        activityDtos = BrcmAPI.GetRequest(BrcmAPI.ActivitiesUrl, ActivityDto[].class);
        if(activityDtos != null){
            choiceActivities.getItems().clear();
            for(ActivityDto activity:activityDtos){
                choiceActivities.getItems().add(activity.getName());
            }
        }
    }

    private void btnRefreshActivities_Clicked(ActionEvent actionEvent) {
        populateDropdown();
    }
}
