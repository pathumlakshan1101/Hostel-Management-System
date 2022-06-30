package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ForgetBO;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 4:08 PM
 */
public class ForgetFormController {

    public JFXTextField txtEmailOrContact;
    public AnchorPane forgetContex;
    public JFXTextField txtFullName;
    public JFXButton btnForget;
    private final ForgetBO forgetBO = (ForgetBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.FORGET);
    public void ForgetOnAction(ActionEvent actionEvent) throws IOException {

        UserDTO userDTO = forgetBO.searchUser(txtFullName.getText());

        if (txtEmailOrContact.getText().equals(userDTO.getEmail()) || txtEmailOrContact.getText().equals(userDTO.getContactNo())){
            UiNavigateUtil.navigationForm(forgetContex,"sign/UpdateUserForm");
        }


    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        UiNavigateUtil.navigationForm(forgetContex,"sign/SignInForm");
    }
}
