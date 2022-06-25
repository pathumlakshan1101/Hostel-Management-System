package com.hibernate.hostel_management_system.controller.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

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
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colStudentContact;
    public TableColumn colStudentDOB;
    public TableColumn colStudentGender;
    public JFXTextField txtStudentId;
    public ToggleGroup gender;

    public void manageStudentOnAction(ActionEvent actionEvent) {
    }
}
