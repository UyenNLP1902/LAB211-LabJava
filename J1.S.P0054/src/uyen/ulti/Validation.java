/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class Validation {

    //1234567890
    private static final String PHONE_VALID_0 = "[0-9]{10}";

    //123-456-7890
    private static final String PHONE_VALID_1 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}";

    //123.456.7890
    private static final String PHONE_VALID_2 = "[0-9]{3}[.][0-9]{3}[.][0-9]{4}";

    //123 456 7890
    private static final String PHONE_VALID_3 = "[0-9]{3}[ ][0-9]{3}[ ][0-9]{4}";

    //123-456-7890 string
    private static final String PHONE_VALID_4 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ ][a-z0-9]+";

    //(123)-456-7890
    private static final String PHONE_VALID_5 = "[(][0-9]{3}[)][-][0-9]{3}[-][0-9]{4}";

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
        return phoneNumber.matches(PHONE_VALID_0)
                || phoneNumber.matches(PHONE_VALID_1)
                || phoneNumber.matches(PHONE_VALID_2)
                || phoneNumber.matches(PHONE_VALID_3)
                || phoneNumber.matches(PHONE_VALID_4)
                || phoneNumber.matches(PHONE_VALID_5);
    }
}
