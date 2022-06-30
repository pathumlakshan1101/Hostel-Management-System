package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.IncomeBO;
import com.hibernate.hostel_management_system.dto.StatusDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
 * Date        : 6/22/2022
 * Time        : 3:36 AM
 */
public class IncomeFormController {
    public TableView<StatusDTO> tblStatus;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn ColRoomId;
    public TableColumn colStatus;
    public JFXTextField txtRoomId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentId;
    public JFXTextField txtKeyMoneyStatus;
    public JFXButton btnUpdateStatus;

    StatusDTO statusDTO;


    private final IncomeBO incomeBO = (IncomeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INCOME);

    public void initialize() throws SQLException, IOException, ClassNotFoundException {



        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        ColRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("keyMoneyStatus"));

        loadAllData();

        btnUpdateStatus.setDisable(true);

        tblStatus.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           statusDTO = newValue;

           if (newValue!=null){
               txtStudentId.setText(newValue.getStudentId());
               txtStudentName.setText(newValue.getStudentName());
               txtRoomId.setText(newValue.getRoomId());
               txtKeyMoneyStatus.setText(newValue.getKeyMoneyStatus());
           }

        });
    }

    private void loadAllData() throws SQLException, IOException, ClassNotFoundException {
        loadModifyStatusTable();
    }

    private void loadModifyStatusTable() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<StatusDTO> allKeyMoneyStatus = incomeBO.getAllKeyMoneyStatus();
        tblStatus.getItems().clear();

        for (StatusDTO statusDTO:allKeyMoneyStatus
        ) {
            tblStatus.getItems().add(statusDTO);
        }
    }


    public void updateStatusOnAction(ActionEvent actionEvent) {



    }

    public void textFieldsKeyRelease(KeyEvent keyEvent) {

    }
}
