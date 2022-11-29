package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.RevenueDto;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class ShowReportsController {
    @FXML
    public BarChart<String, Number> barChart;
    @FXML
    public DatePicker dtEnd;
    @FXML
    public DatePicker dtStart;
    @FXML
    public ChoiceBox choiceCustomerType;
    @FXML
    public Button btnFetchReport;
    @FXML
    public NumberAxis yAxis;
    @FXML
    public CategoryAxis xAxis;

    @FXML
    private void initialize(){
        choiceCustomerType.getItems().add("STUDENT");
        choiceCustomerType.getItems().add("PROFESSOR");
        btnFetchReport.setOnAction(this::btnFetchReport_Clicked);
        xAxis.setLabel("Month-Year");

        yAxis.setLabel("Revenue in $");
    }

    private void btnFetchReport_Clicked(ActionEvent actionEvent) {
        var type = choiceCustomerType.getValue().toString().toUpperCase();
        var url = BrcmAPI.ReportsUrl+type+"/"+dtStart.getValue()+"/"+dtEnd.getValue();
        var result= BrcmAPI.GetRequest(url, RevenueDto[].class);
        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.setName(type);
        for (RevenueDto r: result){
            series1.getData().add(new XYChart.Data<>(r.getBymonth(),r.getTotalRevenue()));
        }
        barChart.getData().clear();
        barChart.getData().add(series1);
    }
}
