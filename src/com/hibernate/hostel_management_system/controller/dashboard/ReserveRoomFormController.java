package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ReserveRoomBO;
import com.hibernate.hostel_management_system.controller.util.LabelUtil;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public JFXComboBox cmbRoomId;
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
    public TableView tblReserve;
    public TableColumn colReserveId;
    public TableColumn Date;
    public TableColumn colStudentId;
    public TableColumn colRoomType;
    public TableColumn colRoomId;
    public TableColumn colStatus;

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        loadAllData();

    }

    private void loadAllData() throws SQLException, IOException, ClassNotFoundException {
        loadAllLabel();
        loadAllTable();
    }

    private void loadAllTable() {

    }

    private void loadAllLabel() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<RoomDTO> allRoom = reserveRoomBO.getAllRoom();
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
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) {
    }
}
