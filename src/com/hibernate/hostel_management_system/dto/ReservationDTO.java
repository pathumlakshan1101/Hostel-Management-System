package com.hibernate.hostel_management_system.dto;

import com.hibernate.hostel_management_system.entity.Room;
import com.hibernate.hostel_management_system.entity.Student;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/27/2022
 * Time        : 8:55 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationDTO {

    private String reserveID;

    private String studentID;

    private String roomID;
    private String roomType;
    private String timeDuration;
    private String status;
    private
    LocalDate reserveDate;
}