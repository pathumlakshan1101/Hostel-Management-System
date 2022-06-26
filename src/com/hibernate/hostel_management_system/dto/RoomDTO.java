package com.hibernate.hostel_management_system.dto;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/26/2022
 * Time        : 7:54 AM
 */
public class RoomDTO {
    private String roomID;
    private String roomType;
    private double monthlyRental;
    private int qty;

    public RoomDTO() {
    }

    public RoomDTO(String roomID, String roomType, double monthlyRental, int qty) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.monthlyRental = monthlyRental;
        this.qty = qty;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getMonthlyRental() {
        return monthlyRental;
    }

    public void setMonthlyRental(double monthlyRental) {
        this.monthlyRental = monthlyRental;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomID='" + roomID + '\'' +
                ", roomType='" + roomType + '\'' +
                ", monthlyRental=" + monthlyRental +
                ", qty=" + qty +
                '}';
    }
}
