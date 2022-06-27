package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ManageBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.AnchorPane;

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
    public TableView<RoomDTO> tblRoom;
    public TableColumn colRoomID;
    public TableColumn colRoomType;
    public TableColumn colRoomMonthlyRental;
    public TableColumn colRoomQty;
    public JFXTextField txtRoomId;
    public AnchorPane manageContex;
    public JFXTextField txtTimeDuration;
    public JFXButton btnManageReservation;
    public TableView<ReservationDTO> tblReserve;
    public TableColumn colReserveId;
    public TableColumn colReserveStudentId;
    public TableColumn colReserveTimeDuration;
    public TableColumn colReserveRoomId;
    public TableColumn colReserveStatus;
    public JFXComboBox cmbStudentId;
    public JFXComboBox cmbRoomId;
    public JFXTextField txtStatus;
    public JFXTextField txtReserveId;
    private StudentDTO studentDTO ;
    private RoomDTO roomDTO;
    private ReservationDTO reservationDTO;
    LinkedHashMap<JFXTextField, Pattern> studentMap = new LinkedHashMap<>();
    LinkedHashMap<JFXTextField, Pattern> roomMap = new LinkedHashMap<>();
    LinkedHashMap<JFXTextField, Pattern> reserveMap = new LinkedHashMap<>();
    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        btnManageRoom.setDisable(true);
        btnManageStudent.setDisable(true);

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


        colReserveId.setCellValueFactory(new PropertyValueFactory<>("reserveID"));
        colReserveStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colReserveTimeDuration.setCellValueFactory(new PropertyValueFactory<>("timeDuration"));
        colReserveRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colReserveStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAllTable();


        Pattern studentNamePattern = Pattern.compile("^[A-Z][a-z]*[ ][A-Z][a-z]*$");
        Pattern contactPattern = Pattern.compile("^(\\+|0)(94|[1-9]{2,3})(-| |)([0-9]{7}|[0-9]{2} [0-9]{7})$");
        Pattern addressPattern = Pattern.compile("^[A-z ]+$");
        Pattern dobPattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");

        studentMap.put(txtStudentName,studentNamePattern);
        studentMap.put(txtStudentContact,contactPattern);
        studentMap.put(txtStudentAddress,addressPattern);
        studentMap.put(txtStudentDOB,dobPattern);


        Pattern roomType = Pattern.compile("^[A-z /,.-]+$");
        Pattern roomMonthlyRental = Pattern.compile("^([0-9]{0,5})(.00)|(.0)$");
        Pattern roomQty = Pattern.compile("^[0-9]{0,5}$");

        roomMap.put(txtRoomType,roomType);
        roomMap.put(txtMonthlyRental,roomMonthlyRental);
        roomMap.put(txtRoomQty,roomQty);

        Pattern timeDuration = Pattern.compile("^[0-9]{1,3}[ ]((month)|(Month))$");
        Pattern statusPattern = Pattern.compile("^((pay)|(non pay))|((Pay)|(Non Pay))$");

        reserveMap.put(txtTimeDuration,timeDuration);
        reserveMap.put(txtStatus,statusPattern);

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnManageStudent.setDisable(false);
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




        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable1, oldValue1, tblRoomNewValue) -> {
            btnManageRoom.setText(tblRoomNewValue!=null ? "Delete Room" : "Manage Room" );
            btnManageRoom.setDisable(false);
            roomDTO=tblRoomNewValue;
            if (!(tblRoomNewValue == null)){
                txtRoomId.setText(tblRoomNewValue.getRoomID());
                txtRoomType.setText(tblRoomNewValue.getRoomType());

                String rent = String.valueOf(tblRoomNewValue.getMonthlyRental());

                int i = rent.indexOf(".");

                String rentals = rent.substring(0,i);

                txtMonthlyRental.setText(rentals);
                txtRoomQty.setText(String.valueOf(tblRoomNewValue.getQty()));
            }
        });
btnManageReservation.setDisable(true);
        tblReserve.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnManageReservation.setText(newValue!=null ? "Delete Reserve" : "Manage reserve");
            btnManageReservation.setDisable(false);
             reservationDTO = newValue;
            if (!(newValue ==null)){
                txtReserveId.setText(newValue.getReserveID());
                cmbStudentId.setValue(newValue.getStudentID());
                cmbRoomId.setValue(newValue.getRoomID());
                txtTimeDuration.setText(newValue.getTimeDuration());
                txtStatus.setText(newValue.getStatus());
            }
        });


        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (reservationDTO!=null){
                if (txtStatus.getText().equals(reservationDTO.getStatus()) && txtTimeDuration.getText().equals(reservationDTO.getTimeDuration()) && cmbStudentId.getValue().equals(reservationDTO.getStudentID() )
                        && cmbRoomId.getValue().equals(reservationDTO.getRoomID())){
                    btnManageReservation.setText("Delete Reserve");
                }else {
                    btnManageReservation.setText("Update Reserve");
                }
            }
        });

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (reservationDTO!=null){
                if (txtStatus.getText().equals(reservationDTO.getStatus()) && txtTimeDuration.getText().equals(reservationDTO.getTimeDuration()) && cmbStudentId.getValue().equals(reservationDTO.getStudentID() )
                        && cmbRoomId.getValue().equals(reservationDTO.getRoomID())){
                    btnManageReservation.setText("Delete Reserve");
                }else {
                    btnManageReservation.setText("Update Reserve");
                }
            }
        });

    }

    private void loadAllTable() throws SQLException, IOException, ClassNotFoundException {
        loadStudentTable();
        loadRoomTable();
        loadReserveTable();
        loadAllComboBox();


    }

    private void loadAllComboBox() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<RoomDTO> allRoom = manageBO.getAllRoom();
        ArrayList<StudentDTO> allStudent = manageBO.getAllStudent();
        cmbRoomId.getItems().clear();
        cmbStudentId.getItems().clear();

        for (RoomDTO roomDTO:allRoom
             ) {
            cmbRoomId.getItems().add(roomDTO.getRoomID());
        }

        for (StudentDTO studentDTO:allStudent
             ) {
            cmbStudentId.getItems().add(studentDTO.getStudentID());
        }
    }

    private void loadReserveTable() throws SQLException, IOException, ClassNotFoundException {
        tblReserve.getItems().clear();

        ArrayList<ReservationDTO> allReservation = manageBO.getAllReservation();

        for (ReservationDTO reservationDTO:allReservation
             ) {
            tblReserve.getItems().add(reservationDTO);
        }
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
        btnManageReservation.setDisable(true);
        btnManageStudent.setDisable(true);
        btnManageRoom.setDisable(true);
        ValidationUtil.validate(studentMap,btnManageStudent);
        ValidationUtil.validate(roomMap,btnManageRoom);
        ValidationUtil.validate(reserveMap,btnManageReservation);


        if (reservationDTO!=null){
            if (txtStatus.getText().equals(reservationDTO.getStatus()) && txtTimeDuration.getText().equals(reservationDTO.getTimeDuration()) && cmbStudentId.getValue().equals(reservationDTO.getStudentID() )
            && cmbRoomId.getValue().equals(reservationDTO.getRoomID())){
                btnManageReservation.setText("Delete Reserve");
            }else {
                btnManageReservation.setText("Update Reserve");
            }
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

        if (!(roomDTO==null)){
            if ( txtRoomType.getText().equals(roomDTO.getRoomType()) && roomDTO.getMonthlyRental()== Double.parseDouble(txtMonthlyRental.getText()) && roomDTO.getQty()==Integer.parseInt(txtRoomQty.getText())
            ){
                btnManageRoom.setText("Delete Room");
            }else {
                btnManageRoom.setText("Update Room");
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
        btnManageStudent.setDisable(false);
    }

    private void clearTextFields() {
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtStudentContact.clear();
        txtStudentDOB.clear();
        txtStudentId.clear();
        rBtnMale.setSelected(true);
        txtRoomId.clear();
        txtRoomType.clear();
        txtMonthlyRental.clear();
        txtRoomQty.clear();
    }

    public void manageRoomOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        if (btnManageRoom.getText().equals("Update Room")){


            if (manageBO.updateRoom(new RoomDTO(txtRoomId.getText(),txtRoomType.getText(),Double.parseDouble(txtMonthlyRental.getText()),Integer.parseInt(txtRoomQty.getText())))){
                NotificationUtil.notificationsConfirm("Room UpDate Successful","UPDATED!");
                loadRoomTable();
                clearTextFields();
            }
        }else if (btnManageRoom.getText().equals("Add Room")){
            if (manageBO.saveRoom(new RoomDTO(txtRoomId.getText(),txtRoomType.getText(),Double.parseDouble(txtMonthlyRental.getText()),Integer.parseInt(txtRoomQty.getText())))){
                NotificationUtil.notificationsConfirm("Room Add Successful","ADDED!");
                loadRoomTable();
                clearTextFields();
            }
        }
        else {


            if (manageBO.deleteRoom(txtRoomId.getText())){
                NotificationUtil.notificationsConfirm("Room Deleted Successful","DELETED!");
                loadRoomTable();
                clearTextFields();
            }

        }
    }

    public void refreshOnMouseClick(MouseEvent mouseEvent) throws IOException {
        UiNavigateUtil.navigationForm(manageContex,"dashboard/ManageForm");
    }

    public void addRoomOnMouseClick(MouseEvent mouseEvent) throws SQLException, IOException, ClassNotFoundException {
        clearTextFields();
        txtRoomId.setText(manageBO.generateNewRoomId());
        roomDTO=null;
        btnManageRoom.setText("Add Room");
        btnManageRoom.setDisable(false);
    }

    public void manageReservationOnAction(ActionEvent actionEvent) {


    }
}
