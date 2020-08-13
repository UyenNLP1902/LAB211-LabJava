/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import uyen.ulti.InputTool;
import java.util.Date;

/**
 *
 * @author SE140355
 */
public class Validation {

    private static String USERNAME_VALID = "^\\S{5}\\S*$";
    private static String PASSWORD_VALID = "^\\S{6}\\S*$";

    public static boolean checkYN(String inMsg, String errorMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    public static boolean checkUsername(String username) {
        return username.matches(USERNAME_VALID);
    }

    public static boolean checkPassword(String password) {
        return password.matches(PASSWORD_VALID);
    }

}
