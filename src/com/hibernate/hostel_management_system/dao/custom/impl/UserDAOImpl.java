package com.hibernate.hostel_management_system.dao.custom.impl;

import com.hibernate.hostel_management_system.dao.custom.UserDAO;
import com.hibernate.hostel_management_system.entity.User;
import com.hibernate.hostel_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 2:42 PM
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
         session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User search(String s) throws SQLException, ClassNotFoundException, IOException {

        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
