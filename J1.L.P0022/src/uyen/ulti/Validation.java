/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.util.ArrayList;
import java.util.Calendar;
import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class Validation {

    private static final String PHONE_VALID = "[0-9]{10,}";

    private static final String EMAIL_VALID = "[A-Za-z0-9.+-_%]{1,}[@][A-Za-z]{1,6}[.][A-Za-z]{2,4}";
    
    private static final int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
    
    public static int checkUpdateChoice() {
        String inMsg = "What do you want to update: \n"
                + "\t1. Update name\n"
                + "\t2. Upadte semester\n"
                + "\t3. Add new course\n"
                + "\t4. Delete course\n"
                + "Your choice: ";
        String errorMsg = "You're supposed to choose from 1 to 4";
        return InputTool.getAnInteger(inMsg, errorMsg, 1, 4);
    }

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

    public static boolean checkGraduationRank(String rank) {
        return rank.equalsIgnoreCase("Excellent") 
                || rank.equalsIgnoreCase("Good")
                || rank.equalsIgnoreCase("Fair")
                || rank.equalsIgnoreCase("Poor");
    }
    
    public static boolean checkGraduationDate(int graduationDate, int birthDate) {
        return graduationDate <= yearCurrent && graduationDate > birthDate;
    }
    
    public static boolean checkExperience(int yearOfExperience, int birthDate) {        
        int age = yearCurrent - birthDate;
        return yearOfExperience < age && yearOfExperience >= 0;
    }
    
    public static boolean checkBirthDate (int birthDate) {
        return birthDate < yearCurrent && birthDate > 1900;
    }
    
    
}
