package com.hibernate.hostel_management_system.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 1:16 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation {
    @Id
    private String reserveID;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Room room;
    private String timeDuration;
    private String status;
    @CreationTimestamp
    private
    LocalDate reserveDate;

}
