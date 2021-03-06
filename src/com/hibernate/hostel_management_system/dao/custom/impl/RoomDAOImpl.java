package com.hibernate.hostel_management_system.dao.custom.impl;

import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.entity.Room;
import com.hibernate.hostel_management_system.entity.Student;
import com.hibernate.hostel_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 2:41 PM
 */
public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException, IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> student = session.createQuery("FROM Room ").list();
        transaction.commit();
        session.close();
        return (ArrayList<Room>) student;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();

        return  true;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();

        return  true;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, s);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(Room.class,s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List max = session.createSQLQuery("SELECT CONCAT(MAX(0+SUBSTRING(roomID,5))) FROM room").list();
        List min = session.createSQLQuery("SELECT CONCAT(MIN(0+SUBSTRING(roomID,5))) FROM room").list();

        transaction.commit();
        session.close();

        if (min.get(0)==null || max.get(0)==null){
            return 0;
        }else {
            if (min.get(0).equals("1")){



                return Integer.parseInt(String.valueOf(max.get(0)))+1;



            }else {

                return Integer.parseInt(String.valueOf(min.get(0)))-1;
            }
        }

    }
}
