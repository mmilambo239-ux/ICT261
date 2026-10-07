package com.customermanager.controller;

import com.customermanager.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController {

    @FXML private TextField nameField;
    @FXML private ComboBox<String> provinceBox;
    @FXML private Button saveButton;
    @FXML private Label statusLabel;
    @FXML private TableView<Customer> customerTable;
    @FXML private TableColumn<Customer, String> nameColumn;
    @FXML private TableColumn<Customer, String> provinceColumn;

    // The table listens to this list, so adding/removing updates the rows
    private final ObservableList<Customer> customers = FXCollections.observableArrayList();

    // Runs automatically after the FXML is loaded
    @FXML
    private void initialize() {
        provinceBox.getItems().addAll("Central", "Copperbelt", "Eastern", "Luapula",
                "Lusaka", "Muchinga", "Northern", "North-Western", "Southern", "Western");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        customerTable.setItems(customers);

        saveButton.setDefaultButton(true); // Enter key activates Save
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            statusLabel.setText("Enter the customer name.");
            nameField.requestFocus();
            return;
        }

        String province = provinceBox.getValue();
        if (province == null) {
            statusLabel.setText("Choose a province.");
            provinceBox.requestFocus();
            return; // the typed name is kept
        }

        customers.add(new Customer(name, province));
        statusLabel.setText("Customer saved.");

        // Clear only after a successful save
        nameField.clear();
        provinceBox.setValue(null);
        nameField.requestFocus();
    }

    @FXML
    private void handleDelete() {
        Customer selected = customerTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            statusLabel.setText("Select a customer to delete.");
            return;
        }

        ButtonType delete = new ButtonType("Delete");
        Alert ask = new Alert(Alert.AlertType.CONFIRMATION,
                "Delete the selected customer?", delete, ButtonType.CANCEL);
        ask.setHeaderText("Confirm deletion");

        if (ask.showAndWait().orElse(ButtonType.CANCEL) == delete) {
            customers.remove(selected);
            statusLabel.setText("Customer deleted.");
        }
    }
}