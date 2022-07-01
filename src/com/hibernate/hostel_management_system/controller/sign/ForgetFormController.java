package com.hibernate.hostel_management_system.controller.sign;

import com.hibernate.hostel_management_system.bo.BOFactory;
import com.hibernate.hostel_management_system.bo.custom.ForgetBO;
import com.hibernate.hostel_management_system.controller.util.NotificationUtil;
import com.hibernate.hostel_management_system.controller.util.UiNavigateUtil;
import com.hibernate.hostel_management_system.controller.util.UserStoreUtil;
import com.hibernate.hostel_management_system.controller.util.ValidationUtil;
import com.hibernate.hostel_management_system.dto.UserDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    LinkedHashMap<JFXTextField, Pattern> forgetMap = new LinkedHashMap<>();

    public  void initialize(){
        btnForget.setDisable(true);

        Pattern fullNamePattern = Pattern.compile("^[A-Z][a-z]*[ ][A-Z][a-z]*$");

        Pattern emailPattern = Pattern.compile("^((\\+|0)(94|[1-9]{2,3})(-| |)([0-9]{7}|[0-9]{2} [0-9]{7}))|(^([a-z\\d.]{3,})@(gmail|yahoo|Outlook|Inbox|iCloud|Mail|AOL|Zoho)(.com|.co.uk)$)$");

        forgetMap.put(txtFullName,fullNamePattern);

        forgetMap.put(txtEmailOrContact,emailPattern);

    }
    public void ForgetOnAction(ActionEvent actionEvent) throws IOException {




        UserDTO userDTO = forgetBO.searchUser(txtFullName.getText());

        if (txtEmailOrContact.getText().equals(userDTO.getEmail()) || txtEmailOrContact.getText().equals(userDTO.getContactNo())){
            UserStoreUtil.userDTO=userDTO;
            UiNavigateUtil.navigationForm(forgetContex,"sign/UpdateUserForm");
        }else {
            txtFullName.clear();
            txtEmailOrContact.clear();
            NotificationUtil.notificationsConfirm("Check Again Full Name And email Or Password","ERROR!");
        }


    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        UiNavigateUtil.navigationForm(forgetContex,"sign/SignInForm");
    }

    public void textFields_Key_Release(KeyEvent keyEvent) {
        ValidationUtil.validate(forgetMap,btnForget);
    }
}
