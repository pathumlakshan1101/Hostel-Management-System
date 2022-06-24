package com.hibernate.hostel_management_system.controller.util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TextField;
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
}
