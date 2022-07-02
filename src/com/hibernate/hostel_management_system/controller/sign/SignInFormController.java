package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.SignInBO;
import com.hibernate.hostel_management_system.bo.custom.SignUpBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    public JFXButton btnSignIn;
    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    LinkedHashMap<JFXPasswordField, Pattern> mapPswd = new LinkedHashMap<>();
    public void initialize() throws SQLException, IOException, ClassNotFoundException {
        btnSignIn.setDisable(true);
        Pattern fullNamePattern = Pattern.compile("^[A-Z][a-z]*");
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,12}$");
        map.put(txtUserName,fullNamePattern);
        mapPswd.put(pswdfldPassword,passwordPattern);
        imgVisibilityOff.setVisible(false);
        txtPassword.setVisible(false);
    }

    public void SignInOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        if (pswdfldPassword.getText().equals(signInBO.search(txtUserName.getText()).getPassword())){
            UiNavigateUtil.newUi(signInContex,"dashboard/DashBoardForm");
        }else {
            NotificationUtil.notificationsError("Wrong Password Or UserName","ERROR");
            btnSignIn.setDisable(true);
        }
        txtUserName.clear();
        pswdfldPassword.clear();


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

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnSignIn);
        ValidationUtil.validatePswd(mapPswd,btnSignIn);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnSignIn);
            Object responsePswd =  ValidationUtil.validatePswd(mapPswd,btnSignIn);
            if (response instanceof JFXTextField) {
                JFXTextField textField = (JFXTextField) response;
                textField.requestFocus();
            } else if (response instanceof Boolean) {}
            if (responsePswd instanceof JFXTextField) {
                JFXPasswordField textField = (JFXPasswordField) response;
                textField.requestFocus();
            } else if (responsePswd instanceof Boolean) {}
        }
    }
}
