package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.UserDTO;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:46 PM
 * @Since : 0.1.0
 */

public interface SignUpBO extends SuperBO {
    boolean saveUser(UserDTO userDTO);
}
