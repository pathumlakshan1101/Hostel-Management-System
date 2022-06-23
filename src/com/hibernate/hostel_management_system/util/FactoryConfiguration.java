package com.hibernate.hostel_management_system.util;

import java.io.IOException;
import java.util.Properties;

import com.hibernate.hostel_management_system.entity.Student;
import com.hibernate.hostel_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/16/2022
 * Time        : 8:55 AM
 */
public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;


    private FactoryConfiguration() throws IOException {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/hibernate/hostel_management_system/resources/hibernate.properties"));
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class)
        .addAnnotatedClass(Student.class);
        sessionFactory=configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration=new FactoryConfiguration()
                : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
