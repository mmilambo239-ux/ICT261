package com.studentregistration.controller;

import com.studentregistration.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistrationController {

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField programField;
    @FXML private TextField emailField;

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> programColumn;
    @FXML private TableColumn<Student, String> emailColumn;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        programColumn.setCellValueFactory(new PropertyValueFactory<>("program"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        studentTable.setItems(studentList);
    }

    @FXML
    private void handleRegister() {
        String id = idField.getText();
        String name = nameField.getText();
        String program = programField.getText();
        String email = emailField.getText();

        if (!id.isEmpty() && !name.isEmpty() && !program.isEmpty()) {
            studentList.add(new Student(id, name, program, email));
            handleClear();
        }
    }

    @FXML
    private void handleClear() {
        if (idField != null) idField.clear();
        if (nameField != null) nameField.clear();
        if (programField != null) programField.clear();
        if (emailField != null) emailField.clear();
    }

    @FXML
    private void handleDelete() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
        }
    }
}