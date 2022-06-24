package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.controller.util.ControllerUtil;
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

    public JFXTextField txtUserName;
    public JFXTextField txtEmailOrContact;
    public AnchorPane forgetContex;

    public void ForgetOnAction(ActionEvent actionEvent) throws IOException {
        ControllerUtil.navigationForm(forgetContex,"sign/UpdateUserForm");
    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        ControllerUtil.navigationForm(forgetContex,"sign/SignInForm");
    }
}
