/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

/**
 *
 * @author SE140355
 */
public class Validation {

    private static final String BINARY_VALID = "[0-1]{1,}";
    private static final String DECIMAL_VALID = "[0-9]{1,}";
    private static final String HEXA_VALID = "[0-9A-F]{1,}";

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

    public static boolean checkBinary(String binary) {
        return binary.matches(BINARY_VALID);
    }

    public static boolean checkDecimal(String decimal) {
        return decimal.matches(DECIMAL_VALID);
    }

    public static boolean checkHexadecimal(String hexadecimal) {
        return hexadecimal.toUpperCase().matches(HEXA_VALID);
    }
}
