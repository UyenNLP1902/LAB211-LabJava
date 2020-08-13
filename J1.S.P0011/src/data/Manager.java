/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    public void convertFromBinary() {
        while (true) {

            int choice = displayConvert("binary", "decimal", "hexadecimal");
            String binary;

            do {
                binary = InputTool.getString("Enter binary: ", "Error");
                if (!Validation.checkBinary(binary)) {
                    System.out.println("Wrong format.");
                }
            } while (!Validation.checkBinary(binary));

            switch (choice) {
                case 1:
                    System.out.println("Decimal = " + convertBinToDec(binary));
                    break;
                case 2:
                    System.out.println("Hexadecimal = " + convertBinToHex(binary));
                    break;
            }

            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }

    }

    public void convertFromDecimal() {
        while (true) {
            int choice = displayConvert("decimal", "hexadecimal", "binary");
            String decimal;

            do {
                decimal = InputTool.getString("Enter binary: ", "Error");
                if (!Validation.checkDecimal(decimal)) {
                    System.out.println("Wrong format.");
                }
            } while (!Validation.checkDecimal(decimal));

            switch (choice) {
                case 1:
                    System.out.println("Hexadecimal = " + convertDecToHex(decimal));
                    break;
                case 2:
                    System.out.println("Binary = " + convertDecToBin(decimal));
                    break;
            }

            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }

    }

    public void convertFromHexadecimal() {

        while (true) {
            int choice = displayConvert("hexadecimal", "binary", "decimal");
            String hexa;

            do {
                hexa = InputTool.getString("Enter hexadecimal: ", "Error");
                if (!Validation.checkHexadecimal(hexa)) {
                    System.out.println("Wrong format.");
                }
            } while (!Validation.checkHexadecimal(hexa));

            switch (choice) {
                case 1:
                    System.out.println("Binary = " + convertHexToBin(hexa));
                    break;
                case 2:
                    System.out.println("Decimal = " + convertHexToDec(hexa));
                    break;
            }
            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }

    }

    //--------------------------------------------------------------------------
    //convert to Dec
    private String convertBinToDec(String bin) {
        int dec = Integer.parseInt(bin, 2);
        return Integer.toString(dec);
    }

    private String convertHexToDec(String hex) {
        int dec = Integer.parseInt(hex, 16);
        return Integer.toString(dec);
    }

    //convert from Dec
    private String convertDecToBin(String dec) {
        String bin = Integer.toBinaryString(Integer.parseInt(dec));
        return bin;
    }

    private String convertDecToHex(String dec) {
        String hex = Integer.toHexString(Integer.parseInt(dec));
        return hex.toUpperCase();
    }

    //others
    private String convertBinToHex(String bin) {
        String dec = convertBinToDec(bin);
        return convertDecToHex(dec).toUpperCase();
    }

    private String convertHexToBin(String hex) {
        String dec = convertHexToDec(hex);
        return convertDecToBin(dec);
    }

    //--------------------------------------------------------------------------
    private int displayConvert(String from, String toCase1, String toCase2) {
        String inMsg = "1. Convert form " + from + " to " + toCase1 + "\n"
                + "2. Convert form " + from + " to " + toCase2 + "\n\n"
                + "Your choice: ";
        String errorMsg = "You're supposed to choose from 1 to 2";
        return InputTool.getAnInteger(inMsg, errorMsg, 1, 2);
    }
}
