package com.hibernate.hostel_management_system.dto;

import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/30/2022
 * Time        : 12:16 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class StatusDTO {
   private String studentId;
    private String studentName;
    private String reserveId;
    private String keyMoneyStatus;

}
