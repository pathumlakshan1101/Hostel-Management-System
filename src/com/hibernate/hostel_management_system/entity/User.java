package com.hibernate.hostel_management_system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 9:08 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


@Entity
public class User {
    @Id
    private String userName;
    private String contactNo;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL)
    private
    List<Student> studentList = new ArrayList<>();

    public User(String userName, String contactNo, String email, String password) {
        this.userName = userName;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
    }


}
