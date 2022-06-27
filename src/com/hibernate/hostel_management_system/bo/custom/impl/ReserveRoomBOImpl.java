package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ReserveRoomBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.ReservationDAO;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dto.ReservationDTO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.hibernate.hostel_management_system.entity.Reservation;
import com.hibernate.hostel_management_system.entity.Room;
import com.hibernate.hostel_management_system.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public String generateNewReservationId() throws SQLException, IOException, ClassNotFoundException {
        int id = reservationDAO.generateNewID();

        if (id==0){
            return "RS0-001";
        }else {
            return  "RS0-00"+id;

        }
    }

    public boolean  saveReserve(ReservationDTO reservationDTO) throws SQLException, IOException, ClassNotFoundException {

        Room room = roomDAO.search(reservationDTO.getRoomID());
        Student student = studentDAO.search(reservationDTO.getStudentID());

        return   reservationDAO.save(new Reservation(reservationDTO.getReserveID(),student,room,reservationDTO.getTimeDuration(),reservationDTO.getStatus(), LocalDate.now()));
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
    public String generateNewStudentId() throws SQLException, IOException, ClassNotFoundException {

        int id = studentDAO.generateNewID();

        if (id==0){
            return "S00-001";
        }else {
            return  "S00-00"+id;

        }

    }

    public StudentDTO searchStudent(String id) throws SQLException, IOException, ClassNotFoundException {
        Student search = studentDAO.search(id);
        if (search==null){
            return new StudentDTO();
        }else {        return new StudentDTO(search.getStudentID(),search.getStudentName(),search.getStudentAddress(),search.getStudentContact(),search.getDateOfBirth(),search.getGender());


        }
    }
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();

        for (Student s:all
        ) {
            allStudent.add(new StudentDTO(s.getStudentID(),s.getStudentName(),s.getStudentAddress(),s.getStudentContact(),s.getDateOfBirth(),s.getGender()));
        }
        return allStudent;
    }
}
