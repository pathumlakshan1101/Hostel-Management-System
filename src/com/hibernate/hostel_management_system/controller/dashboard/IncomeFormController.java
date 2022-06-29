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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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


    public void updateStatusOnAction(ActionEvent actionEvent) {



    }
}
