package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ReserveRoomBO;
import com.hibernate.hostel_management_system.controller.util.LabelUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/20/2022
 * Time        : 7:32 AM
 */
public class ReserveRoomFormController {

    public Label lblRoomTypeAndID1;
    public Label lblMonthlyRental1;
    public Label lblAvailable1;
    public Label lblRoomTypeAndID2;
    public Label lblMonthlyRental2;
    public Label lblAvailable2;
    public Label lblRoomTypeAndID3;
    public Label lblMonthlyRental3;
    public Label lblAvailable3;
    public Label lblRoomTypeAndID4;
    public Label lblMonthlyRental4;
    public Label lblAvailable4;
    public Label lblRoomTypeAndID5;
    public Label lblMonthlyRental5;
    public Label lblAvailable5;
    private final ReserveRoomBO reserveRoomBO = (ReserveRoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVE);
    public JFXComboBox<String> cmbRoomId;
    public JFXComboBox cmbStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentContact;
    public JFXTextField txtStudentDOB;
    public JFXRadioButton rBtnMale;
    public JFXRadioButton rBtnFeMale;
    public JFXTextField txtReserveId;
    public JFXButton btnReserveRoom;
    public JFXTextField txtKeyMoneyStatus;
    public JFXTextField txtTimeDuration;
    public TableView<ReservationDTO> tblReserve;
    public TableColumn colReserveId;
    public TableColumn colDate;
    public TableColumn colStudentId;
    public TableColumn colRoomID;
    public TableColumn ColTimeDuration;
    public TableColumn colStatus;
    public ToggleGroup gender;
    ArrayList<RoomDTO> allRoom;
    LinkedHashMap<JFXTextField, Pattern> reserveMap = new LinkedHashMap<>();

    public void initialize() throws SQLException, IOException, ClassNotFoundException {
        allRoom=reserveRoomBO.getAllRoom();
        btnReserveRoom.setDisable(true);
        loadAllData();

        Pattern studentNamePattern = Pattern.compile("^[A-Z][a-z]*[ ][A-Z][a-z]*$");
        Pattern contactPattern = Pattern.compile("^(\\+|0)(94|[1-9]{2,3})(-| |)([0-9]{7}|[0-9]{2} [0-9]{7})$");
        Pattern addressPattern = Pattern.compile("^[A-z ]+$");
        Pattern dobPattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
        Pattern timeDuration = Pattern.compile("^[0-9]{1,3}[ ]((month)|(Month))$");
        Pattern statusPattern = Pattern.compile("^((pay)|(non pay))|((Pay)|(Non Pay))$");

        reserveMap.put(txtStudentName,studentNamePattern);
        reserveMap.put(txtStudentContact,contactPattern);
        reserveMap.put(txtStudentAddress,addressPattern);
        reserveMap.put(txtStudentDOB,dobPattern);
        reserveMap.put(txtTimeDuration,timeDuration);
        reserveMap.put(txtKeyMoneyStatus,statusPattern);

        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                txtReserveId.setText(reserveRoomBO.generateNewReservationId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                if (newValue.equals("   ")){
                    try {
                        cmbStudentId.setValue(reserveRoomBO.generateNewStudentId());

                        btnReserveRoom.setText("Reserve Room And Save Student");
                        txtStudentName.clear();
                        txtStudentAddress.clear();
                        txtStudentContact.clear();
                        txtStudentDOB.clear();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }else {
                    btnReserveRoom.setText("Reserve Room");
                    try {


                            StudentDTO studentDTO = reserveRoomBO.searchStudent((String) newValue);

                            txtStudentName.setText(studentDTO.getStudentName());
                            txtStudentAddress.setText(studentDTO.getStudentAddress());
                            txtStudentContact.setText(studentDTO.getStudentContact());
                            txtStudentDOB.setText(studentDTO.getDateOfBirth());
                            if (studentDTO.getGender()=="Male"){
                                rBtnMale.setSelected(true);

                            }else {rBtnFeMale.setSelected(true);}



                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadAllData() throws SQLException, IOException, ClassNotFoundException {
        loadAllLabel();
        loadAllTable();
        loadComboBox();
    }

    private void loadComboBox() throws SQLException, IOException, ClassNotFoundException {
        cmbStudentId.getItems().clear();
        cmbRoomId.getItems().clear();

        for (RoomDTO roomDTO:allRoom
             ) {

            if (roomDTO.getQty()>0){cmbRoomId.getItems().add(roomDTO.getRoomType()+"  "+roomDTO.getRoomID());}


        }
        ArrayList<StudentDTO> allStudent = reserveRoomBO.getAllStudent();

        for (StudentDTO studentDTO:allStudent
             ) {
            cmbStudentId.getItems().add(studentDTO.getStudentID());
        }
        cmbStudentId.getItems().add("   ");
    }

    private void loadAllTable() throws SQLException, IOException, ClassNotFoundException {

        colReserveId.setCellValueFactory(new PropertyValueFactory<>("reserveID"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("reserveDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        ColTimeDuration.setCellValueFactory(new PropertyValueFactory<>("timeDuration"));


        tblReserve.getItems().clear();

        ArrayList<ReservationDTO> allReservation = reserveRoomBO.getAllReservation();
        tblReserve.getItems().clear();
        for (ReservationDTO r :allReservation
             ) {
            tblReserve.getItems().add(r);
        }

    }

    private void loadAllLabel() throws SQLException, IOException, ClassNotFoundException {

        ArrayList<LabelUtil> allLabel = new ArrayList<>();
        allLabel.add(new LabelUtil(lblRoomTypeAndID1, lblMonthlyRental1, lblAvailable1));
        allLabel.add(new LabelUtil(lblRoomTypeAndID2, lblMonthlyRental2, lblAvailable2));
        allLabel.add(new LabelUtil(lblRoomTypeAndID3, lblMonthlyRental3, lblAvailable3));
        allLabel.add(new LabelUtil(lblRoomTypeAndID4, lblMonthlyRental4, lblAvailable4));
        allLabel.add(new LabelUtil(lblRoomTypeAndID5, lblMonthlyRental5, lblAvailable5));

        for (int i = 0; i < allLabel.size(); i++) {
            if (i< allRoom.size()){
                allLabel.get(i).getTypeAndId().setText(allRoom.get(i).getRoomID()+"  "+allRoom.get(i).getRoomType());
                allLabel.get(i).getRental().setText(String.valueOf(allRoom.get(i).getMonthlyRental()));
                allLabel.get(i).getAvailable().setText(allRoom.get(i).getQty()==0 ? "UnAvailable" : "Available");
            }else {
                allLabel.get(i).getTypeAndId().setText("UnAvailable");
                allLabel.get(i).getRental().setText("UnAvailable");
                allLabel.get(i).getAvailable().setText("UnAvailable");
            }
        }

    }

    public void textFields_on_key_release(KeyEvent keyEvent) {
        ValidationUtil.validate(reserveMap,btnReserveRoom);
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) {
        if (btnReserveRoom.getText().equals("Reserve Room")){

        }else {}
    }
}
