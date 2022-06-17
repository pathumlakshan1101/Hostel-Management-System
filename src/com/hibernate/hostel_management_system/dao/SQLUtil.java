package com.hibernate.hostel_management_system.dao;

import com.hibernate.hostel_management_system.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/16/2022
 * Time        : 10:41 PM
 */
public class SQLUtil {

    public static <T> T execute(String sql, Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement statement =
                DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject((i+1),params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) statement.executeQuery();
        }else{
            return ((T)(Boolean)(statement.executeUpdate()>0));
        }
    }
}
