package com.hibernate.hostel_management_system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 8:54 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


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
        @OneToMany(mappedBy = "student" ,fetch = FetchType.EAGER ,orphanRemoval = true)
        private  List<Reservation> reservationList = new ArrayList<>();

    public Student(String studentID) {
        this.studentID = studentID;
    }


    public Student(String studentID, String studentName, String studentAddress, String studentContact, String dateOfBirth, String gender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

}
