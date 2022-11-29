package edu.cpp.brcm.frontend;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.function.Function;

public class EditButtonTableCell<S> extends TableCell<S, Button> {
    private final Button actionButton;

    public EditButtonTableCell(String label, Function< S, S> function) {
        this.getStyleClass().add("action-button-table-cell");

        this.actionButton = new Button(label);

        this.actionButton.setOnAction((ActionEvent e) -> {
            function.apply(getCurrentItem());
        });
        //this.actionButton.setMaxWidth(Double.MAX_VALUE);
        this.actionButton.setMaxSize(100, 50);
        this.actionButton.setPadding(new Insets(2,2,2,2));
    }

    public S getCurrentItem() {
        return (S) getTableView().getItems().get(getIndex());
    }

    public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> forTableColumn(String label, Function< S, S> function) {
        return param -> new EditButtonTableCell<>(label, function);
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