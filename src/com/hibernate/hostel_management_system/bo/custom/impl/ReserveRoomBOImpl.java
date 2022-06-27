package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ReserveRoomBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.ReservationDAO;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.entity.Reservation;
import com.hibernate.hostel_management_system.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:54 PM
 */
public class ReserveRoomBOImpl implements ReserveRoomBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    public ArrayList<RoomDTO> getAllRoom() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room:all
        ) {
            allRoom.add(new RoomDTO(room.getRoomID(),room.getRoomType(),room.getMonthlyRental(),room.getQty()));
        }
        return allRoom;
    }

    public ArrayList<ReservationDTO> getAllReservation() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Reservation> all = reservationDAO.getAll();
        ArrayList<ReservationDTO> allReserve = new ArrayList<>();

        for (Reservation reservation:all
             ) {
            allReserve.add(new ReservationDTO(reservation.getReserveID(),reservation.getStudent().getStudentID(),reservation.getRoom().getRoomID(),reservation.getRoom().getRoomType(),reservation.getTimeDuration(),reservation.getStatus(),reservation.getReserveDate()));
        }
        return allReserve;
    }
}
