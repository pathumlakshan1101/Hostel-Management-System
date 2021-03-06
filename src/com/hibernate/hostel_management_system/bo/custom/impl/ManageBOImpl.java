package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ManageBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.ReservationDAO;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dao.custom.UserDAO;
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
public class ManageBOImpl implements ManageBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    public ArrayList<ReservationDTO> getAllReservation() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Reservation> all = reservationDAO.getAll();
        ArrayList<ReservationDTO> allReserve = new ArrayList<>();

        for (Reservation reservation:all
        ) {
            allReserve.add(new ReservationDTO(reservation.getReserveID(),reservation.getStudent().getStudentID(),reservation.getRoom().getRoomID(),reservation.getRoom().getRoomType(),reservation.getTimeDuration(),reservation.getStatus(),reservation.getReserveDate()));
        }
        return allReserve;
    }
    public ArrayList<RoomDTO> getAllRoom() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room:all
             ) {
            allRoom.add(new RoomDTO(room.getRoomID(),room.getRoomType(),room.getMonthlyRental(),room.getQty()));
        }
        return allRoom;
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

    public String generateNewId() throws SQLException, IOException, ClassNotFoundException {

        int id = studentDAO.generateNewID();

        if (id==0){
            return "S00-001";
        }else {
            return  "S00-00"+id;

        }

    }

    public boolean saveRoom (RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException {
        return roomDAO.save(new Room(roomDTO.getRoomID(),roomDTO.getRoomType(),roomDTO.getMonthlyRental(),roomDTO.getQty()));
    }

    public String generateNewRoomId() throws SQLException, IOException, ClassNotFoundException {
        int id = roomDAO.generateNewID();
        if (id==0){
            return "R00-001";
        }else {
            return "R00-00"+id;
        }
    }

public boolean deleteRoom(String s) throws SQLException, IOException, ClassNotFoundException {
        return roomDAO.delete(s);
}
    public boolean deleteStudent(String s) throws SQLException, IOException, ClassNotFoundException {
        return studentDAO.delete(s);
    }

    public boolean updateStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException {
       return studentDAO.update(new Student(studentDTO.getStudentID(),studentDTO.getStudentName(),studentDTO.getStudentAddress(),studentDTO.getStudentContact(),studentDTO.getDateOfBirth(),studentDTO.getGender()));
    }
    public boolean updateRoom(RoomDTO roomDTO) throws SQLException, IOException, ClassNotFoundException {
       return roomDAO.update(new Room(roomDTO.getRoomID(), roomDTO.getRoomType(),roomDTO.getMonthlyRental(), roomDTO.getQty()));
    }

    public boolean updateReserve(ReservationDTO reservationDTO) throws SQLException, IOException, ClassNotFoundException {
        Room room = roomDAO.search(reservationDTO.getRoomID());
        Student student = studentDAO.search(reservationDTO.getStudentID());

        Room search = roomDAO.search(reservationDTO.getOldRoomId());
        search.setQty(search.getQty()+1);
        roomDAO.update(search);

        Room search1 = roomDAO.search(reservationDTO.getRoomID());
        search1.setQty(search1.getQty()-1);
        roomDAO.update(search1);

        return  reservationDAO.update(new Reservation(reservationDTO.getReserveID(),student,room,reservationDTO.getTimeDuration(),reservationDTO.getStatus(), LocalDate.now()));
    }
    public boolean deleteReservation(String id,String roomId) throws SQLException, IOException, ClassNotFoundException {

        Room search = roomDAO.search(roomId);
        search.setQty(search.getQty()+1);
        roomDAO.update(search);

       return reservationDAO.delete(id);
    }


    public boolean save(StudentDTO studentDTO) throws SQLException, IOException, ClassNotFoundException {
       return studentDAO.save(new Student(studentDTO.getStudentID(),studentDTO.getStudentName(),studentDTO.getStudentAddress(),studentDTO.getStudentContact(),studentDTO.getDateOfBirth(),studentDTO.getGender()));
    }
}
