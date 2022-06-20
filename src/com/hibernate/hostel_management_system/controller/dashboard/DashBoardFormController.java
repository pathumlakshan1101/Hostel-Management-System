package com.hibernate.hostel_management_system.controller.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.scene.input.MouseEvent;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/18/2022
 * Time        : 2:22 AM
 */
public class DashBoardFormController {

    public JFXButton r1;
    public JFXButton r2;
    boolean b=false;

    public void initialize(){
        r1.setVisible(false);
        r2.setVisible(false);
    }

    public void hamburgerMenuOnMouseClick(MouseEvent mouseEvent) {
        if (b==false){
            r1.setVisible(true);
            r2.setVisible(true);
            b=true;
        }else if (b==true){
            r1.setVisible(false);
            r2.setVisible(false);
            b=false;
        }
    }
}
