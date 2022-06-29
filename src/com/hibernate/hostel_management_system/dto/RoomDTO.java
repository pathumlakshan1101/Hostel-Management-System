package com.hibernate.hostel_management_system.dto;

import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/26/2022
 * Time        : 7:54 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class RoomDTO {
    private String roomID;
    private String roomType;
    private double monthlyRental;
    private int qty;

}
