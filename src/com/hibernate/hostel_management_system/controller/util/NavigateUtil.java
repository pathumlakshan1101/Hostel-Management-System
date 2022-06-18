package com.hibernate.hostel_management_system.controller.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 7:44 PM
 */
public class NavigateUtil {
    public static void navigationForm(AnchorPane anchorPane,String url) throws IOException {
        anchorPane.getChildren().clear();
        Parent parent = FXMLLoader.load(NavigateUtil.class.getResource("../view/fxml/"+url+""));
        anchorPane.getChildren().add(parent);
    }
}
