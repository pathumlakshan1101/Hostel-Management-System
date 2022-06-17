package com.hibernate.hostel_management_system.bo;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/16/2022
 * Time        : 11:02 PM
 */
public class BOFactory {
        private static BOFactory boFactory;

        private BOFactory(){}

        public static BOFactory getBoFactory(){
                return (boFactory == null) ? boFactory=new BOFactory() : boFactory;
        }
}
