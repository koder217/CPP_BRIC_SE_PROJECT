package edu.cpp.brcm.frontend;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.HashMap;

public class HelloController {
    private HashMap<String, Node> viewMap;
    @FXML
    private TreeView menuTreeView;
    @FXML
    private Node viewPriceHistory;
    @FXML
    private Node viewManageActivities;
    @FXML
    private Node viewManageDiscounts;
    @FXML
    private Node viewManageOrders;
    @FXML
    private Node viewManageCustomers;
    @FXML
    private Node viewShowReports;

    @FXML
    public void initialize(){
        viewMap = new HashMap<>();
        viewMap.put("Price History", viewPriceHistory);
        viewMap.put("Activities", viewManageActivities);
        viewMap.put("Discounts", viewManageDiscounts);
        viewMap.put("Customers", viewManageCustomers);
        viewMap.put("Orders", viewManageOrders);
        viewMap.put("Reports", viewShowReports);
        menuTreeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem newVal = (TreeItem) newValue;
            System.out.println(newVal.getValue().toString());
            changeView(newVal.getValue().toString());
        });
    }

    private void changeView(String viewName){
        viewMap.forEach((k,v)->{ v.setVisible(false); });
        viewMap.get(viewName).setVisible(true);
    }
}