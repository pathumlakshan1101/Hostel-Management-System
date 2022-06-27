package com.hibernate.hostel_management_system.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 8:54 AM
 */

@Entity
public class Student {
        @Id
        private String studentID;
        private String studentName;
        private String studentAddress;
        private String studentContact;
        private String dateOfBirth;
        private String gender;
        @ManyToOne
        private User user;
        @OneToMany(mappedBy = "student" ,fetch = FetchType.EAGER)
        private  List<Reservation> reservationList = new ArrayList<>();

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender, User user, List<Reservation> reservationList) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.user = user;
        this.reservationList = reservationList;
    }

    public Student(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Student() {
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", user=" + user +
                ", reservationList=" + reservationList +
                '}';
    }
}
