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

    public static boolean checkUD() {
        while (true) {
            String result = InputTool.getString("Do you want to update (U) or delete (D): ", "Please input again: ");
            if (result.equalsIgnoreCase("U")) {
                return true;
            }

            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Please input u/U or d/D only.");
        }
    }

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

    public static boolean checkCourseValidation(String courseName) {
        if (courseName.equalsIgnoreCase("Java") || courseName.equalsIgnoreCase(".Net") || courseName.equalsIgnoreCase("C/C++")) {
            return true;
        }
        System.out.println("There are only 3 courses now: Java, .Net, C/C++.");
        return false;
    }

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
}
