package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.controller.util.NavigateUtil;
import com.jfoenix.controls.JFXButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/18/2022
 * Time        : 2:22 AM
 */
public class DashBoardFormController {

    public JFXButton r1;
    public JFXButton r2;
    public AnchorPane dashBoardContex;
    boolean b=false;

    public void initialize(){
        r1.setVisible(false);
        r2.setVisible(false);
    }

    public void hamburgerMenuOnMouseClick(MouseEvent mouseEvent) {
        if (!b){
            r1.setVisible(true);
            r2.setVisible(true);
            b=true;
        }else if (b){
            r1.setVisible(false);
            r2.setVisible(false);
            b=false;
        }
    }

    public void homeDashBoardOnMouseClick(MouseEvent mouseEvent) {
    }

    public void logOutDashBoardOnMouseClick(MouseEvent mouseEvent) throws IOException {
        NavigateUtil.newUi(dashBoardContex,"sign/SignForm","Sign In");
    }

    public void closeDashBoardOnMouseClick(MouseEvent mouseEvent) {
        NavigateUtil.closeForm(dashBoardContex);
    }

}
