package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.IncomeBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.StatusDTO;
import com.hibernate.hostel_management_system.view.tdm.StatusTM;
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
    public TableView<StatusTM> tblStatus;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn ColRoomId;
    public TableColumn colStatus;
    public JFXTextField txtRoomId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentId;
    public JFXTextField txtKeyMoneyStatus;
    public JFXButton btnUpdateStatus;

    StatusTM statusTM;

    LinkedHashMap<JFXTextField, Pattern> statusMap = new LinkedHashMap<>();



    private final IncomeBO incomeBO = (IncomeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INCOME);

    public void initialize() throws SQLException, IOException, ClassNotFoundException {



        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        ColRoomId.setCellValueFactory(new PropertyValueFactory<>("reserveId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("keyMoneyStatus"));


        Pattern statusPattern = Pattern.compile("^((payed)|(non payed))|((Payed)|(Non Payed))$");

        statusMap.put(txtKeyMoneyStatus,statusPattern);

        loadAllData();

        btnUpdateStatus.setDisable(true);

        tblStatus.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            statusTM = newValue;

           if (newValue!=null){
               txtStudentId.setText(newValue.getStudentId());
               txtStudentName.setText(newValue.getStudentName());
               txtRoomId.setText(newValue.getReserveId());
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
            tblStatus.getItems().add(new StatusTM(statusDTO.getStudentId(),statusDTO.getStudentName(),statusDTO.getReserveId(),statusDTO.getKeyMoneyStatus()));
        }
    }


    public void updateStatusOnAction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        if(txtKeyMoneyStatus.getText().equals(statusTM.getKeyMoneyStatus())){
            clearTextFields();
        }else {
           if( incomeBO.updateKeyMoneyStatus(new StatusDTO(txtStudentId.getText(),txtStudentName.getText(),txtRoomId.getText(),txtKeyMoneyStatus.getText()))){
               NotificationUtil.notificationsConfirm("Successful Update Key Money Status","UPDATED!");
               clearTextFields();
               loadAllData();
           }
        }
    }

    private void clearTextFields() {
        txtStudentName.clear();
        txtStudentId.clear();
        txtRoomId.clear();
        txtKeyMoneyStatus.clear();
    }

    public void textFieldsKeyRelease(KeyEvent keyEvent) {

        ValidationUtil.validate(statusMap,btnUpdateStatus);


    }
}
