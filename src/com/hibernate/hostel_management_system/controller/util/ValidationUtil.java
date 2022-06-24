package com.hibernate.hostel_management_system.controller.util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Color;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/24/2022
 * Time        : 8:18 AM
 */
public class ValidationUtil {
    public static Object validate(LinkedHashMap<JFXTextField, Pattern> map, JFXButton btn) {
        for (JFXTextField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (!pattern.matcher(key.getText()).matches()){
                addError(key,btn);
                return key;
            }
            removeError(key,btn);
        }
        return true;
    }

    public static Object validatePswd(LinkedHashMap<JFXPasswordField, Pattern> map, JFXButton btn) {
        for (JFXPasswordField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (!pattern.matcher(key.getText()).matches()){
                addErrorPswd(key,btn);
                return key;
            }
            removeErrorPswd(key,btn);
        }
        return true;
    }

    private static void removeError(JFXTextField txtField,JFXButton btn) {
        txtField.setFocusColor(Color.GREEN);
        btn.setDisable(false);
    }

    private static void addError(JFXTextField txtField,JFXButton btn) {
        if (txtField.getText().length() > 0) {
            txtField.setFocusColor(Color.RED);
        }
        btn.setDisable(true);
    }

    private static void removeErrorPswd(JFXPasswordField txtField,JFXButton btn) {
        txtField.setFocusColor(Color.GREEN);
        btn.setDisable(false);
    }

    private static void addErrorPswd(JFXPasswordField txtField,JFXButton btn) {
        if (txtField.getText().length() > 0) {
            txtField.setFocusColor(Color.RED);
        }
        btn.setDisable(true);
    }
}
