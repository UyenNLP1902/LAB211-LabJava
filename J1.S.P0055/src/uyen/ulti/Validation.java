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

    public static boolean checkYN() {
        while (true) {
            String result = InputTool.getString("Do you want to continue (Y/N)?: ", "Please input again: ");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }
    
    public static int checkUpdateChoice() {
        String inMsg = "What do you want to update: \n"
                + "\t1. Update name\n"
                + "\t2. Update specialization\n"
                + "\t3. Update availability\n"
                + "Your choice: ";
        String errorMsg = "You're supposed to choose from 1 to 3";
        return InputTool.getAnInteger(inMsg, errorMsg, 1, 3);
    }
    
    public static boolean checkAvailability (int availability) {
        return availability > 0;
    }
    
    public static boolean checkDelete() {
        while (true) {
            String result = InputTool.getString("This person will be deleted. Are you sure (Y/N)?: ", "Please input again: ");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }
}
