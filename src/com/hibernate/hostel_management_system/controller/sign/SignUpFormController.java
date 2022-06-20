package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.controller.util.NavigateUtil;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 8:49 PM
 */
public class SignUpFormController {
    public JFXTextField txtFullName;
    public JFXPasswordField pswdfldPassword;
    public JFXTextField txtPassword;
    public ImageView imgVisibilityOn;
    public ImageView imgVisibilityOff;
    public JFXTextField txtContactNo;
    public JFXTextField txtEmail;
    public AnchorPane signUpContex;

    public void initialize(){
        imgVisibilityOff.setVisible(false);
        txtPassword.setVisible(false);
    }

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {

        NavigateUtil.navigationForm(signUpContex,"sign/SignInForm");
    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {

        NavigateUtil.navigationForm(signUpContex,"sign/SignInForm");
    }

    public void visibilityOnMouseEntered(MouseEvent mouseEvent) {

        imgVisibilityOff.setVisible(true);
        pswdfldPassword.setVisible(false);
        txtPassword.setVisible(true);
        txtPassword.setText(pswdfldPassword.getText());
    }

    public void visibilityOnMouseExited(MouseEvent mouseEvent) {

        imgVisibilityOff.setVisible(false);
        pswdfldPassword.setVisible(true);
        txtPassword.setVisible(false);
    }
}
