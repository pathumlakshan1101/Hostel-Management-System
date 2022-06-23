package com.hibernate.hostel_management_system.dao.custom.impl;

import com.hibernate.hostel_management_system.dao.custom.ReservationDAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 2:40 PM
 */
public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public ArrayList<ReservationDAO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ReservationDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ReservationDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ReservationDAO search(String s) throws SQLException, ClassNotFoundException {
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
