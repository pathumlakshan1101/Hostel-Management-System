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
    private String oldRoomId;
    private String timeDuration;
    private String status;
    private
    LocalDate reserveDate;

    public ReservationDTO(String reserveID, String studentID, String roomID, String timeDuration, String status, LocalDate reserveDate) {
        this.reserveID = reserveID;
        this.studentID = studentID;
        this.roomID = roomID;
        this.timeDuration = timeDuration;
        this.status = status;
        this.reserveDate = reserveDate;
    }
}