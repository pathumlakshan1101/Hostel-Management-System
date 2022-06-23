package com.hibernate.hostel_management_system.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 9:08 AM
 */
@Entity
public class User {
    @Id
    private String userName;
    private String contactNo;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private
    List<Student> studentList = new ArrayList<>();

    public User(String userName, String contactNo, String email, String password, List<Student> studentList) {
        this.userName = userName;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
        this.studentList = studentList;
    }

    public User(String userName, String contactNo, String email, String password) {
        this.userName = userName;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
