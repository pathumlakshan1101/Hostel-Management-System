package com.hibernate.hostel_management_system.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 12:10 AM
 * @Since : 0.1.0
 */

public interface CrudDAO <T,ID> extends SuperDAO{

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;


}
