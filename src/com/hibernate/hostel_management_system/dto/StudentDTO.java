package com.hibernate.hostel_management_system.dto;

import com.hibernate.hostel_management_system.entity.Reservation;
import com.hibernate.hostel_management_system.entity.User;
import lombok.*;

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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


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

}
