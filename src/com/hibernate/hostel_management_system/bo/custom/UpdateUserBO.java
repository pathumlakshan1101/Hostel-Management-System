package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:47 PM
 * @Since : 0.1.0
 */

public interface UpdateUserBO extends SuperBO {
    boolean updateUser(UserDTO userDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean deleteUser(String id) throws IOException, SQLException, ClassNotFoundException;
}
