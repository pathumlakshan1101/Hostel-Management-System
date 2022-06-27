package com.hibernate.hostel_management_system.dao.custom.impl;

import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.entity.Reservation;
import com.hibernate.hostel_management_system.entity.Student;
import com.hibernate.hostel_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 2:42 PM
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException, IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> student = session.createQuery("FROM Student ").list();
        transaction.commit();
        session.close();
        return (ArrayList<Student>) student;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();


        return true;

    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student load = session.get(Student.class, s);
        transaction.commit();
        session.close();
        return load;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(Student.class,s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public int generateNewID() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List max = session.createSQLQuery("SELECT CONCAT(MAX(0+SUBSTRING(studentID,5))) FROM student").list();
        List min = session.createSQLQuery("SELECT CONCAT(MIN(0+SUBSTRING(studentID,5))) FROM student").list();

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
