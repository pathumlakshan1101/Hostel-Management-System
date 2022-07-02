package com.hibernate.hostel_management_system.view.tdm;

import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 7/2/2022
 * Time        : 1:23 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class StudentTM {
    private String studentID;
    private String studentName;
    private String studentAddress;
    private String studentContact;
    private String dateOfBirth;
    private String gender;
}
