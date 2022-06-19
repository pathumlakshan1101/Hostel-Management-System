package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.controller.util.NavigateUtil;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 3:17 AM
 */
public class SignFormController {
    public AnchorPane signPagesContex;

    public void initialize() throws IOException {
        NavigateUtil.navigationForm(signPagesContex,"sign/SignInForm","Sign In");
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        NavigateUtil.closeForm(signPagesContex);
    }
}