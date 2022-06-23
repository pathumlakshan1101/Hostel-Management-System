package com.hibernate.hostel_management_system.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 1:16 PM
 */

@Entity
public class Reservation {
    @Id
    private String reserveID;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Room room;
    private String timeDuration;
    private String status;
    @CreationTimestamp
    private
    LocalDate reserveDate;

    public Reservation(String reserveID, Student student, Room room, String timeDuration, String status, LocalDate reserveDate) {
        this.reserveID = reserveID;
        this.student = student;
        this.room = room;
        this.timeDuration = timeDuration;
        this.status = status;
        this.reserveDate = reserveDate;
    }

    public Reservation() {
    }

    public String getReserveID() {
        return reserveID;
    }

    public void setReserveID(String reserveID) {
        this.reserveID = reserveID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reserveID='" + reserveID + '\'' +
                ", student=" + student +
                ", room=" + room +
                ", timeDuration='" + timeDuration + '\'' +
                ", status='" + status + '\'' +
                ", reserveDate=" + reserveDate +
                '}';
    }
}
