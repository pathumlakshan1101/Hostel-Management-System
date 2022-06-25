package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ManageBO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/20/2022
 * Time        : 10:28 AM
 */
public class ManageFormController {
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentDOB;
    public JFXRadioButton rBtnMale;
    public JFXRadioButton rBtnFemale;
    public JFXButton btnManageStudent;
    public TableView<StudentDTO> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colStudentContact;
    public TableColumn colStudentDOB;
    public TableColumn colStudentGender;
    public JFXTextField txtStudentId;
    public ToggleGroup gender;
    private final ManageBO manageBO = (ManageBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MANAGE);
    private StudentDTO studentDTO ;
    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("studentAddress"));
        colStudentContact.setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        colStudentDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colStudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadAllTable();

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                studentDTO=newValue;
            btnManageStudent.setText(newValue != null ? "Delete Student" : "Manage Student");

            txtStudentId.setText(newValue.getStudentID());
            txtStudentName.setText(newValue.getStudentName());
            txtStudentAddress.setText(newValue.getStudentAddress());
            txtStudentContact.setText(newValue.getStudentContact());
            txtStudentDOB.setText(newValue.getDateOfBirth());
            if (newValue.getGender().equals("Male")){
                rBtnMale.setSelected(true);
            }else {
                rBtnFemale.setSelected(true);
            }

        });
    }

    private void loadAllTable() throws SQLException, IOException, ClassNotFoundException {
        loadStudentTable();
    }

    private void loadStudentTable() throws SQLException, IOException, ClassNotFoundException {
        tblStudent.getItems().clear();

        ArrayList<StudentDTO> allStudent = manageBO.getAllStudent();

        for (StudentDTO student:allStudent
             ) {
            tblStudent.getItems().add(student);
        }


    }

    public void manageStudentOnAction(ActionEvent actionEvent) {



    }

    public void textFields_Key_Released(KeyEvent keyEvent) {

        if (txtStudentName.getText().equals(studentDTO.getStudentName())&&txtStudentAddress.getText().equals(studentDTO.getStudentAddress())
            &&txtStudentContact.getText().equals(studentDTO.getStudentContact()) &&txtStudentDOB.getText().equals(studentDTO.getDateOfBirth())
        ){
            btnManageStudent.setText("Delete Student");
        }else {
            btnManageStudent.setText("Update Student");
        }

    }

    public void radiobuttonOnMouseClick(MouseEvent mouseEvent) {
        String gender = null;
        if (rBtnFemale.isSelected()){
            gender="FeMale";
        }else if (rBtnMale.isSelected()){
            gender="Male";
        }

        if (gender.equals(studentDTO.getGender())){
            btnManageStudent.setText("Delete Student");
        }else {
            btnManageStudent.setText("Update Student");
        }

    }

    public void addStudentOnMouseClick(MouseEvent mouseEvent) throws SQLException, IOException, ClassNotFoundException {
        clearTextFields();
        btnManageStudent.setText("Add Student");
        txtStudentId.setText(manageBO.generateNewId());
    }

    private void clearTextFields() {
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStudentContact.clear();
        txtStudentDOB.clear();
        txtStudentId.clear();
        rBtnMale.setSelected(true);
    }
}
