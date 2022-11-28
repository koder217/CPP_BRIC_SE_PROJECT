package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.DiscountschemeDto;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

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
    private void btnRefreshDiscounts_Clicked(ActionEvent e) {
        refreshGrid();
    }

    @FXML
    private void btnAddNewDiscount_Clicked(ActionEvent e) {
        lblDiscountId.setText("New");
        txtDiscountPercent.setText("");
        txtDiscountPrice.setText("");
        choiceCustomerType.setValue(null);
        dtStart.setValue(LocalDate.now());
        dtEnd.setValue(LocalDate.now().plusWeeks(1));
    }

    @FXML
    public void initialize() {
        btnAddNewDiscount.setOnAction(this::btnAddNewDiscount_Clicked);
        btnRefreshDiscounts.setOnAction(this::btnRefreshDiscounts_Clicked);
        btnSaveChanges.setOnAction(this::btnSaveChanges_Clicked);

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

        TableColumn<DiscountschemeDto, LocalDate> column5 =
                new TableColumn<>("Start Date");
        column5.setCellValueFactory(
                new PropertyValueFactory<>("startdate"));

        TableColumn<DiscountschemeDto, LocalDate> column6 =
                new TableColumn<>("End Date");
        column6.setCellValueFactory(
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

    private void btnSaveChanges_Clicked(ActionEvent actionEvent) {
        try {
            var discountId = lblDiscountId.getText();
            var priceDiscount = Double.parseDouble(txtDiscountPrice.getText());
            var percentDiscount = Double.parseDouble(txtDiscountPercent.getText());
            var startDt = dtStart.getValue();
            var endDt = dtEnd.getValue();
            var customerType = choiceCustomerType.getValue();
            if (Objects.equals(discountId, "New") || Objects.equals(discountId, "") || Objects.equals(discountId, null)) {
                var dto = new DiscountschemeDto(0, priceDiscount, percentDiscount, customerType, startDt, endDt);
                DiscountschemeDto result = BrcmAPI.PostRequest(BrcmAPI.DiscountsUrl, dto, DiscountschemeDto.class);
            } else {
                var dto = new DiscountschemeDto(Integer.parseInt(discountId), priceDiscount, percentDiscount, customerType, startDt, endDt);
                BrcmAPI.PutRequest(BrcmAPI.DiscountsUrl + discountId, dto);
            }
            refreshGrid();
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void refreshGrid() {
        var dto = BrcmAPI.GetRequest(BrcmAPI.DiscountsUrl, DiscountschemeDto[].class);
        if (dto != null) {
            System.out.println(dto.length);
            tableDiscounts.getItems().clear();
            for (var d : dto) {
                tableDiscounts.getItems().add(d);
            }
            selectionModel.select(0);
        }
    }

    private void deleteDiscount(DiscountschemeDto p) {
        try {
            BrcmAPI.DeleteRequest(BrcmAPI.DiscountsUrl + p.getId().toString());
            refreshGrid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
