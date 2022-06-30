package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.UpdateUserBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.dao.DAOFactory;
import com.hibernate.hostel_management_system.dao.custom.UserDAO;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/23/2022
 * Time        : 5:15 PM
 */
public class UpdateUserFormController {
    public AnchorPane updateContex;
    public JFXTextField txtFullName;
    public JFXPasswordField pswdfldPassword;
    public JFXTextField txtPassword;
    public ImageView imgVisibilityOn;
    public ImageView imgVisibilityOff;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNo;
    public JFXButton btnUpdate;
    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    LinkedHashMap<JFXPasswordField, Pattern> mapPswd = new LinkedHashMap<>();
    private final UpdateUserBO updateUserBO = (UpdateUserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.UPDATEUSER);

    public void initialize() {

        imgVisibilityOff.setVisible(false);
        txtPassword.setVisible(false);


    }


    public void updateOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        if (updateUserBO.updateUser(new UserDTO(txtFullName.getText(),txtContactNo.getText(),txtEmail.getText(),pswdfldPassword.getText()))){
            clearFields();
            NotificationUtil.notificationsConfirm("Update User Successful","UPDATED!");
            navigateSignInPage();
        }



    }

    private void clearFields() {
        txtPassword.clear();
        txtContactNo.clear();
        txtFullName.clear();
        txtEmail.clear();
        pswdfldPassword.clear();
    }

    private void navigateSignInPage() throws IOException {
        UiNavigateUtil.navigationForm(updateContex,"sign/SignInForm");
    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        navigateSignInPage();
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
