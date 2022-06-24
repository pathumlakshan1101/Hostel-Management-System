package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.SignInBO;
import com.hibernate.hostel_management_system.bo.custom.SignUpBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.QueryDAO;
import com.hibernate.hostel_management_system.dao.custom.UserDAO;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.hibernate.hostel_management_system.entity.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:55 PM
 */
public class SignUpBOImpl implements SignUpBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO userDTO) throws SQLException, IOException, ClassNotFoundException {

        return userDAO.save(new User(userDTO.getUserName(), userDTO.getContactNo(), userDTO.getEmail(), userDTO.getPassword()));
    }
}
