package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.SignInBO;
import com.hibernate.hostel_management_system.bo.custom.SignUpBO;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 10:25 AM
 */
public class SignInFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField pswdfldPassword;
    public JFXTextField txtPassword;
    public ImageView imgVisibilityOn;
    public ImageView imgVisibilityOff;
    public AnchorPane signInContex;
    private final SignInBO signInBO = (SignInBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SIGNIN);

    public void initialize() throws SQLException, IOException, ClassNotFoundException {

        UserDTO pathum = signInBO.search("Pathum");

        System.out.println(pathum.getUserName());
        System.out.println(pathum.getPassword());

        imgVisibilityOff.setVisible(false);
        txtPassword.setVisible(false);
    }

    public void SignInOnAction(ActionEvent actionEvent) throws IOException {


        UiNavigateUtil.newUi(signInContex,"dashboard/DashBoardForm");

    }

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        UiNavigateUtil.navigationForm(signInContex,"sign/SignUpForm");

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

    public void forgetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        UiNavigateUtil.navigationForm(signInContex,"sign/ForgetForm");
    }
}
