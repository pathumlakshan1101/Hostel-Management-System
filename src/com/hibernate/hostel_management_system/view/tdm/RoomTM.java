package com.hibernate.hostel_management_system.view.tdm;

import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 7/2/2022
 * Time        : 2:02 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class RoomTM {
    private String roomID;
    private String roomType;
    private double monthlyRental;
    private int qty;
}
