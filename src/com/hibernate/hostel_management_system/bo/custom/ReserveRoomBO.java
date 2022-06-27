package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:52 PM
 * @Since : 0.1.0
 */

public interface ReserveRoomBO extends SuperBO {
     ArrayList<RoomDTO> getAllRoom() throws SQLException, IOException, ClassNotFoundException;
    ArrayList<ReservationDTO> getAllReservation() throws SQLException, IOException, ClassNotFoundException;
}
