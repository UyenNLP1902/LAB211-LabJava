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

    public static boolean checkYN(String inMsg, String errorMsg) {
        while (true) {
            String result = MyToys.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    public static boolean checkUD() {
        while (true) {
            String result = MyToys.getString("Do you want to update or delete student? (U/D): ", "Error occured. Please input again");
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
                + "\t2. Add new course\n"
                + "\t3. Delete course\n"
                + "Your choice: ";
        String errorMsg = "You're supposed to choose from 1 to 3";
        return MyToys.getAnInteger(inMsg, errorMsg, 1, 3);
    }

    public static boolean checkCourseValidation(String courseName) {
        if (courseName.equalsIgnoreCase("Java") || courseName.equalsIgnoreCase(".Net") || courseName.equalsIgnoreCase("C/C++")) {
            return true;
        }
        System.out.println("There are only 3 courses now: Java, .Net, C/C++.");
        return false;
    }

    public static String getCourse(String inpMsg, String errMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inpMsg);
                n = MyToys.getAnInteger(inpMsg, errMsg);
                if (n < 1 || n > 3) throw new Exception();
                if (n == 1) return "Java";
                if (n == 2) return "C/C++";
                if (n == 3) return ".Net";
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
}
