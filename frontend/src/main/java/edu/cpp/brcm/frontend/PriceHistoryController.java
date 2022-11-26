package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.ActivityDto;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

public class PriceHistoryController {
    @FXML
    private ChoiceBox choiceActivities;
    @FXML
    public void initialize(){
        List<ActivityDto> dto = BrcmAPI.GetRequest(BrcmAPI.ActivitiesUrl, ArrayList.class);
        var items= choiceActivities.getItems();
        items.add("Swimming");
        items.add("Dancing");
        items.add("Yoga");
        choiceActivities.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println(choiceActivities.getItems().get((Integer) number2));
            }
        });
    }
}
