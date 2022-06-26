package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ReserveRoomBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
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

    public ArrayList<RoomDTO> getAllRoom() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room:all
        ) {
            allRoom.add(new RoomDTO(room.getRoomID(),room.getRoomType(),room.getMonthlyRental(),room.getQty()));
        }
        return allRoom;
    }
}
