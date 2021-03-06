package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.StatusDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:51 PM
 * @Since : 0.1.0
 */

public interface IncomeBO extends SuperBO {
    ArrayList<StatusDTO> getAllKeyMoneyStatus() throws SQLException, IOException, ClassNotFoundException;
    boolean updateKeyMoneyStatus(StatusDTO statusDTO) throws SQLException, IOException, ClassNotFoundException;
}
