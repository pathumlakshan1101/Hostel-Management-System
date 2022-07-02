package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
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
    public JFXButton btnSignUp;
    private final SignUpBO signUpBO = (SignUpBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SIGNUP);
    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    LinkedHashMap<JFXPasswordField, Pattern> mapPswd = new LinkedHashMap<>();

    public void initialize(){
        imgVisibilityOff.setVisible(false);
        txtPassword.setVisible(false);
        btnSignUp.setDisable(true);


        Pattern fullNamePattern = Pattern.compile("^[A-Z][a-z]*[ ][A-Z][a-z]*$");
        Pattern contactPattern = Pattern.compile("^(\\+|0)(94|[1-9]{2,3})(-| |)([0-9]{7}|[0-9]{2} [0-9]{7})$");
        Pattern emailPattern = Pattern.compile("^([a-z\\d.]{3,})@(gmail|yahoo|Outlook|Inbox|iCloud|Mail|AOL|Zoho)(.com|.co.uk)$");
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,12}$");

        map.put(txtFullName,fullNamePattern);
        map.put(txtContactNo,contactPattern);
        map.put(txtEmail,emailPattern);
        mapPswd.put(pswdfldPassword,passwordPattern);


    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnSignUp);
        ValidationUtil.validatePswd(mapPswd,btnSignUp);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnSignUp);
            Object responsePswd =  ValidationUtil.validatePswd(mapPswd,btnSignUp);
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

    public void signUpOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {


        if (
        signUpBO.saveUser(new UserDTO(txtFullName.getText(),txtContactNo.getText(),txtEmail.getText(),pswdfldPassword.getText()))
        ){
            NotificationUtil.notificationsConfirm("Save User Detail","SAVE!");
            UiNavigateUtil.navigationForm(signUpContex,"sign/SignInForm");
        }else {
            NotificationUtil.notificationsError("Can't Save User Detail","ERROR!");
        }

        clearFields();

    }

    private void clearFields() {
        txtPassword.clear();
        txtContactNo.clear();
        txtEmail.clear();
        txtFullName.clear();
        pswdfldPassword.clear();
    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {

        UiNavigateUtil.navigationForm(signUpContex,"sign/SignInForm");
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
