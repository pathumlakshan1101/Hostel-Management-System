package com.hibernate.hostel_management_system.bo.custom;

import com.hibernate.hostel_management_system.bo.SuperBO;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:51 PM
 * @Since : 0.1.0
 */

public interface ManageBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException;
    String generateNewId() throws SQLException, IOException, ClassNotFoundException;
    boolean save(StudentDTO studentDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean updateStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException;
    boolean deleteStudent(String s) throws SQLException, IOException, ClassNotFoundException;
    ArrayList<RoomDTO> getAllRoom() throws SQLException, IOException, ClassNotFoundException;
    boolean updateRoom(RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException;
    boolean deleteRoom(String s) throws SQLException, IOException, ClassNotFoundException;
    String generateNewRoomId() throws SQLException, IOException, ClassNotFoundException;
    boolean saveRoom (RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException;
    ArrayList<ReservationDTO> getAllReservation() throws SQLException, IOException, ClassNotFoundException;
    boolean updateReserve(ReservationDTO reservationDTO) throws SQLException, IOException, ClassNotFoundException;

    boolean deleteReservation(String id,String roomId) throws SQLException, IOException, ClassNotFoundException;
}
