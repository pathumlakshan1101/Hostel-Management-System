package com.hibernate.hostel_management_system.bo.custom.impl;

import com.hibernate.hostel_management_system.bo.custom.ManageBO;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.RoomDAO;
import com.hibernate.hostel_management_system.dao.custom.StudentDAO;
import com.hibernate.hostel_management_system.dao.custom.UserDAO;
import com.hibernate.hostel_management_system.dto.RoomDTO;
import com.hibernate.hostel_management_system.dto.StudentDTO;
import com.hibernate.hostel_management_system.entity.Room;
import com.hibernate.hostel_management_system.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
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


        if (studentDAO.generateNewID()==0){
            return "S00-001";
        }else {
            return  "S00-00"+studentDAO.generateNewID();

        }



    }

    public boolean deleteStudent(String s) throws SQLException, IOException, ClassNotFoundException {
        return studentDAO.delete(s);
    }

    public boolean updateStudent(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, IOException {
       return studentDAO.update(new Student(studentDTO.getStudentID(),studentDTO.getStudentName(),studentDTO.getStudentAddress(),studentDTO.getStudentContact(),studentDTO.getDateOfBirth(),studentDTO.getGender()));
    }

    public boolean save(StudentDTO studentDTO) throws SQLException, IOException, ClassNotFoundException {
       return studentDAO.save(new Student(studentDTO.getStudentID(),studentDTO.getStudentName(),studentDTO.getStudentAddress(),studentDTO.getStudentContact(),studentDTO.getDateOfBirth(),studentDTO.getGender()));
    }
}
