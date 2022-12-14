package edu.cpp.brcm.frontend;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.function.Function;

public class DeleteButtonTableCell<S> extends TableCell<S, Button> {
    private final Button actionButton;

    public DeleteButtonTableCell(String label, Function< S, S> function) {
        this.getStyleClass().add("action-button-table-cell");

        this.actionButton = new Button(label);

        this.actionButton.setOnAction((ActionEvent e) -> {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Are you sure?");
            a.setHeaderText("Confirm Deletion");
            a.showAndWait().ifPresent(b-> {
                if (b == ButtonType.YES || b == ButtonType.OK){
                    function.apply(getCurrentItem());
                }
            });
        });
        //this.actionButton.setMaxWidth(Double.MAX_VALUE);
        this.actionButton.setMaxSize(100, 50);
        this.actionButton.setPadding(new Insets(2,2,2,2));
    }

    public S getCurrentItem() {
        return (S) getTableView().getItems().get(getIndex());
    }

    public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> forTableColumn(String label, Function< S, S> function) {
        return param -> new DeleteButtonTableCell<>(label, function);
    }

    @Override
    public void updateItem(Button item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(actionButton);
        }
    }
}