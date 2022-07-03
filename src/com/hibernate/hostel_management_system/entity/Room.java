package com.hibernate.hostel_management_system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 12:34 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Room {
    @Id
    private String roomID;
    private String roomType;
    private double monthlyRental;
    private int qty;
    @OneToMany(mappedBy = "room" , fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    public Room(String roomID) {
        this.roomID = roomID;
    }

    public Room(String roomID, String roomType, double monthlyRental, int qty) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.monthlyRental = monthlyRental;
        this.qty = qty;
    }
}
