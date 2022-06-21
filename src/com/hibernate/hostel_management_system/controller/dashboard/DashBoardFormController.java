package com.hibernate.hostel_management_system.controller.dashboard;

import com.hibernate.hostel_management_system.controller.util.NavigateUtil;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
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


    public AnchorPane dashBoardContex;
    public JFXButton btnReserveRoom;
    public AnchorPane workingContex;
    public ImageView imgHome;
    public JFXButton btnManageForm;
    boolean b=false;

    public void initialize() throws IOException {
        btnReserveRoom.setVisible(false);
        btnManageForm.setVisible(false);
        openReservePage();

    }

    public void hamburgerMenuOnMouseClick(MouseEvent mouseEvent) {
        if (!b){
            btnReserveRoom.setVisible(true);
            btnManageForm.setVisible(true);
            b=true;
        }else if (b){
            btnReserveRoom.setVisible(false);
            btnManageForm.setVisible(false);
            b=false;
        }
    }

    public void homeDashBoardOnMouseClick(MouseEvent mouseEvent) throws IOException {
        openReservePage();
    }

    public void logOutDashBoardOnMouseClick(MouseEvent mouseEvent) throws IOException {
        NavigateUtil.newUi(dashBoardContex,"sign/SignForm");
    }

    public void closeDashBoardOnMouseClick(MouseEvent mouseEvent) {
        NavigateUtil.closeForm(dashBoardContex);
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) throws IOException {

        openReservePage();
    }

    private void openReservePage() throws IOException {
        NavigateUtil.navigationForm(workingContex,"dashboard/ReserveRoomForm");
        imgHome.setVisible(false);
    }

    public void manageOnAction(ActionEvent actionEvent) throws IOException {
        NavigateUtil.navigationForm(workingContex,"dashboard/ManageForm");
        imgHome.setVisible(true);
    }
}
