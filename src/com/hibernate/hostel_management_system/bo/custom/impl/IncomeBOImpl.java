package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.IncomeBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.ReservationDAO;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dto.StatusDTO;
import com.hibernate.hostel_management_system.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 10:54 PM
 */
public class IncomeBOImpl implements IncomeBO {
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    public ArrayList<StatusDTO> getAllKeyMoneyStatus() throws SQLException, IOException, ClassNotFoundException {

        ArrayList<Reservation> all = reservationDAO.getAll();
        ArrayList<StatusDTO> allKeyMoneyStatus = new ArrayList<>();



        for (Reservation reservation:all
             ) {

            if (reservation.getStatus().equals("non payed") || reservation.getStatus().equals("Non Payed")){
                allKeyMoneyStatus.add(new StatusDTO(reservation.getStudent().getStudentID(),reservation.getStudent().getStudentName(),reservation.getReserveID(),reservation.getStatus()));

            }

        }
        return allKeyMoneyStatus;
    }


    public boolean updateKeyMoneyStatus(StatusDTO statusDTO) throws SQLException, IOException, ClassNotFoundException {

        Reservation search = reservationDAO.search(statusDTO.getRoomId());

        search.setStatus(statusDTO.getKeyMoneyStatus());

      return   reservationDAO.update(search);
    }
}
