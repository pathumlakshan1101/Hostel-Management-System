package com.hibernate.hostel_management_system.view.tdm;

import lombok.*;

import java.time.LocalDate;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 7/2/2022
 * Time        : 12:58 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class ReservationTM {

    private String reserveID;
    private String studentID;
    private String roomID;
    private String timeDuration;
    private String status;
    private LocalDate reserveDate;

}
