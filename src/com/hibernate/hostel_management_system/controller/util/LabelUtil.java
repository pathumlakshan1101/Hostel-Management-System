package com.hibernate.hostel_management_system.controller.util;

import javafx.scene.control.Label;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/26/2022
 * Time        : 11:33 PM
 */
public class LabelUtil {
    private Label typeAndId;
    private Label rental;
    private Label available;

    public LabelUtil() {
    }

    public LabelUtil(Label typeAndId, Label rental, Label available) {
        this.typeAndId = typeAndId;
        this.rental = rental;
        this.available = available;
    }

    public Label getTypeAndId() {
        return typeAndId;
    }

    public void setTypeAndId(Label typeAndId) {
        this.typeAndId = typeAndId;
    }

    public Label getRental() {
        return rental;
    }

    public void setRental(Label rental) {
        this.rental = rental;
    }

    public Label getAvailable() {
        return available;
    }

    public void setAvailable(Label available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "LabelUtil{" +
                "typeAndId=" + typeAndId +
                ", rental=" + rental +
                ", available=" + available +
                '}';
    }
}
