package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.StudentDTO;

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

public interface ManageBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException;
}
