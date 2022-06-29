package com.hibernate.hostel_management_system.controller.util;

import javafx.scene.control.Label;
import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/26/2022
 * Time        : 11:33 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LabelRoom {
    private Label typeAndId;
    private Label rental;
    private Label available;

}
