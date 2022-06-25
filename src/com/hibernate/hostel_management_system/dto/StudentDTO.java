package com.hibernate.hostel_management_system.dto;

import com.hibernate.hostel_management_system.entity.Reservation;
import com.hibernate.hostel_management_system.entity.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/25/2022
 * Time        : 10:19 AM
 */
public class StudentDTO {
    private String studentID;
    private String studentName;
    private String studentAddress;
    private String studentContact;
    private String dateOfBirth;
    private String gender;
    private String userName;
    private List<Reservation> reservationList = new ArrayList<>();

    public StudentDTO(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public StudentDTO(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender, String userName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userName = userName;
    }

    public StudentDTO(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender, String userName, List<Reservation> reservationList) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userName = userName;
        this.reservationList = reservationList;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", reservationList=" + reservationList +
                '}';
    }
}
