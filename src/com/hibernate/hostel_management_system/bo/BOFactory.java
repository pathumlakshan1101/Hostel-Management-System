package com.hibernate.hostel_management_system.bo;

import com.hibernate.hostel_management_system.bo.custom.impl.*;

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

        public enum BOTypes{
                FORGET,INCOME,MANAGE,RESERVE,SIGNIN,SIGNUP,UPDATEUSER
        }

        public SuperBO getBO(BOTypes boTypes){
                switch (boTypes){
                        case FORGET:
                                return new ForgetBOImpl();

                        case INCOME:
                                return new IncomeBOImpl();

                        case MANAGE:
                                return new ManageBOImpl();

                        case RESERVE:
                                return new ReserveRoomBOImpl();

                        case SIGNIN:
                                return new SignInBOImpl();

                        case SIGNUP:
                                return new SignUpBOImpl();

                        case UPDATEUSER:
                                return new UpdateUserBOImpl();

                        default:
                                return null;
                }
        }
}
