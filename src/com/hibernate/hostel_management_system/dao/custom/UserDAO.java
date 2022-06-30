package com.hibernate.hostel_management_system.dao.custom;

import com.hibernate.hostel_management_system.dao.CrudDAO;
import com.hibernate.hostel_management_system.entity.Room;
import com.hibernate.hostel_management_system.entity.User;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 2:36 PM
 * @Since : 0.1.0
 */

public interface UserDAO extends CrudDAO<User,String> {
    public User searchUser(String fullName) throws IOException;
}
