/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SE140355
 */
public class Validation {

    private static final String PHONE_VALID = "[0-9]{10,11}";
    private static final String EMAIL_VALID = "[A-Za-z0-9.+-_%]{1,}[@][A-Za-z]{1,6}[.][A-Za-z]{2,4}";

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

    public static boolean checkPhone(String phoneNumber) {
        return phoneNumber.matches(PHONE_VALID);
    }

    public static boolean checkEmail(String email) {
        return email.matches(EMAIL_VALID);
    }

    public static boolean checkDate(String inputDate) {
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(inputDate);

                if (inputDate.equalsIgnoreCase(dateFormat.format(date))) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

    }
}
