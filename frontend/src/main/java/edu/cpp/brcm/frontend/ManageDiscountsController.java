package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.DiscountschemeDto;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageDiscountsController {
    @FXML
    public TextField txtDiscountPrice;
    @FXML
    public DatePicker dtStart;
    @FXML
    public TextField txtDiscountPercent;
    @FXML
    public Label lblDiscountId;
    @FXML
    public DatePicker dtEnd;
    @FXML
    public Button btnSaveChanges;
    @FXML
    public TableView tableDiscounts;
    @FXML
    public Button btnAddNewDiscount;
    @FXML
    public Button btnRefreshDiscounts;
    @FXML
    public ChoiceBox<String> choiceCustomerType;
    private TableView.TableViewSelectionModel<DiscountschemeDto> selectionModel;

    @FXML
    public void initialize(){
        choiceCustomerType.getItems().add("STUDENT");
        choiceCustomerType.getItems().add("PROFESSOR");
        tableDiscounts.setPlaceholder(
                new Label("No discounts to display. Try adding one!"));

        TableColumn<DiscountschemeDto, Integer> columnId =
                new TableColumn<>("Id");
        columnId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn<DiscountschemeDto, String> column1 =
                new TableColumn<>("$ Discount");
        column1.setCellValueFactory(
                new PropertyValueFactory<>("pricediscount"));

        TableColumn<DiscountschemeDto, String> column2 =
                new TableColumn<>("% Discount");
        column2.setCellValueFactory(
                new PropertyValueFactory<>("percentdiscount"));

        TableColumn<DiscountschemeDto, String> column4 =
                new TableColumn<>("Customer Type");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("customertype"));

        TableColumn<DiscountschemeDto, String> column5 =
                new TableColumn<>("Start Date");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("startdate"));

        TableColumn<DiscountschemeDto, String> column6 =
                new TableColumn<>("End Date");
        column4.setCellValueFactory(
                new PropertyValueFactory<>("enddate"));

        TableColumn<DiscountschemeDto, Button> column3 =
                new TableColumn<>("Delete");
        column3.setCellFactory(ActionButtonTableCell.<DiscountschemeDto>forTableColumn("Remove", (DiscountschemeDto p) -> {
            deleteDiscount(p);
            return p;
        }));
        tableDiscounts.getColumns().add(columnId);
        tableDiscounts.getColumns().add(column1);
        tableDiscounts.getColumns().add(column2);
        tableDiscounts.getColumns().add(column4);
        tableDiscounts.getColumns().add(column5);
        tableDiscounts.getColumns().add(column6);
        tableDiscounts.getColumns().add(column3);
        selectionModel = tableDiscounts.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        refreshGrid();
        selectionModel.select(0);
        ObservableList<DiscountschemeDto> selectedItems =
                selectionModel.getSelectedItems();

        selectedItems.addListener(
                new ListChangeListener<DiscountschemeDto>() {
                    @Override
                    public void onChanged(
                            Change<? extends DiscountschemeDto> change) {
                        var ol = change.getList();
                        if (ol.size() > 0) {
                            DiscountschemeDto ad = change.getList().get(0);
                            lblDiscountId.setText(ad.getId().toString());
                            txtDiscountPrice.setText(ad.getPricediscount().toString());
                            txtDiscountPercent.setText(ad.getPercentdiscount().toString());
                            dtStart.setValue(ad.getStartdate());
                            dtEnd.setValue(ad.getEnddate());
                            choiceCustomerType.setValue(ad.getCustomertype().toUpperCase());
                        }
                    }
                });
    }

    private void refreshGrid() {
        
    }

    private void deleteDiscount(DiscountschemeDto p) {

    }
}
