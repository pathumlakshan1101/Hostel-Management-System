package com.hibernate.hostel_management_system.dto;

import lombok.*;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/24/2022
 * Time        : 7:51 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class UserDTO {
     private String userName;
     private String contactNo;
     private String email;
     private String password;



    public UserDTO(String password) {
        this.password = password;
    }


}
