package com.hibernate.hostel_management_system.controller.util;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/24/2022
 * Time        : 8:17 AM
 */
public class NotificationUtil {

    public static void notificationsConfirm(String text, String title){
        Notifications notifications=Notifications.create();
        notifications.darkStyle();
        notifications.text(text);
        notifications.title(title);
        notifications.hideAfter(Duration.seconds(4));
        notifications.showInformation();
    }
    public static void notificationsError(String text, String title){
        Notifications notifications=Notifications.create();

        notifications.darkStyle();
        notifications.text(text);
        notifications.title(title);
        notifications.hideAfter(Duration.seconds(4));
        notifications.showError();
    }

}
