package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ManageBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    public JFXTextField txtRoomType;
    public JFXTextField txtMonthlyRental;
    public JFXTextField txtRoomQty;
    public JFXButton btnManageRoom;
    public TableView tblRoom;
    public TableColumn colRoomID;
    public TableColumn colRoomType;
    public TableColumn colRoomMonthlyRental;
    public TableColumn colRoomQty;
    public JFXTextField txtRoomId;
    private StudentDTO studentDTO ;
    LinkedHashMap<JFXTextField, Pattern> studentMap = new LinkedHashMap<>();
    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("studentAddress"));
        colStudentContact.setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        colStudentDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colStudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));


        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colRoomMonthlyRental.setCellValueFactory(new PropertyValueFactory<>("monthlyRental"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadAllTable();


        Pattern studentNamePattern = Pattern.compile("^[A-Z][a-z]*[ ][A-Z][a-z]*$");
        Pattern contactPattern = Pattern.compile("^(\\+|0)(94|[1-9]{2,3})(-| |)([0-9]{7}|[0-9]{2} [0-9]{7})$");
        Pattern addressPattern = Pattern.compile("^[A-z ]+$");
        Pattern dobPattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");

        studentMap.put(txtStudentName,studentNamePattern);
        studentMap.put(txtStudentContact,contactPattern);
        studentMap.put(txtStudentAddress,addressPattern);
        studentMap.put(txtStudentDOB,dobPattern);
        btnManageStudent.setDisable(true);


        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                studentDTO=newValue;
            btnManageStudent.setText(newValue != null ? "Delete Student" : "Manage Student");

            if (!(newValue ==null)){
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
            }



        });
    }

    private void loadAllTable() throws SQLException, IOException, ClassNotFoundException {
        loadStudentTable();
        loadRoomTable();


    }

    private void loadRoomTable() throws SQLException, IOException, ClassNotFoundException {
        tblRoom.getItems().clear();
        ArrayList<RoomDTO> allRoom = manageBO.getAllRoom();

        for (RoomDTO room:allRoom
             ) {
            tblRoom.getItems().add(room);
        }
    }

    private void loadStudentTable() throws SQLException, IOException, ClassNotFoundException {
        tblStudent.getItems().clear();

        ArrayList<StudentDTO> allStudent = manageBO.getAllStudent();

        for (StudentDTO student:allStudent
             ) {
            tblStudent.getItems().add(student);
        }


    }

    public void manageStudentOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        if (btnManageStudent.getText().equals("Add Student")){
            String gender = null;
            if (rBtnFemale.isSelected()){
                gender="FeMale";
            }else if (rBtnMale.isSelected()){
                gender="Male";
            }


            if (manageBO.save(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentContact.getText(),txtStudentDOB.getText(),gender))){
                NotificationUtil.notificationsConfirm("Successful Add Customer","ADDED!");
                clearTextFields();
                loadStudentTable();
            }

        }else if (btnManageStudent.getText().equals("Update Student")){
            String gender = null;
            if (rBtnFemale.isSelected()){
                gender="FeMale";
            }else if (rBtnMale.isSelected()){
                gender="Male";
            }


            if (manageBO.updateStudent(new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtStudentAddress.getText(),txtStudentContact.getText(),txtStudentDOB.getText(),gender))){
                NotificationUtil.notificationsConfirm("Successful UpDate Customer","UPDATED!");
                clearTextFields();
                loadStudentTable();
            }

        }else {


            if (manageBO.deleteStudent(txtStudentId.getText())){
                NotificationUtil.notificationsConfirm("Successful Delete Customer","DELETED!");
                clearTextFields();
                loadStudentTable();
            }

        }


    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(studentMap,btnManageStudent);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(studentMap,btnManageStudent);

            if (response instanceof JFXTextField) {
                JFXTextField textField = (JFXTextField) response;
                textField.requestFocus();
            } else if (response instanceof Boolean) {}

        }
        if (!(studentDTO ==null)){
            if (txtStudentName.getText().equals(studentDTO.getStudentName())&&txtStudentAddress.getText().equals(studentDTO.getStudentAddress())
                    &&txtStudentContact.getText().equals(studentDTO.getStudentContact()) &&txtStudentDOB.getText().equals(studentDTO.getDateOfBirth())
            ){
                btnManageStudent.setText("Delete Student");
            }else {
                btnManageStudent.setText("Update Student");
            }
        }



    }

    public void radiobuttonOnMouseClick(MouseEvent mouseEvent) {

        if (!(studentDTO ==null)){

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


    }

    public void addStudentOnMouseClick(MouseEvent mouseEvent) throws SQLException, IOException, ClassNotFoundException {
        clearTextFields();
        btnManageStudent.setText("Add Student");
        txtStudentId.setText(manageBO.generateNewId());
        studentDTO=null;
    }

    private void clearTextFields() {
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStudentContact.clear();
        txtStudentDOB.clear();
        txtStudentId.clear();
        rBtnMale.setSelected(true);
    }

    public void manageRoomOnAction(ActionEvent actionEvent) {
    }
}
