package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ForgetBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.UserDAO;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.hibernate.hostel_management_system.entity.User;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:53 PM
 */
public class ForgetBOImpl implements ForgetBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    public UserDTO searchUser(String id) throws IOException {
        User user = userDAO.searchUser(id);
        return new UserDTO(user.getUserName(), user.getContactNo(), user.getEmail(), user.getPassword());
    }
}
