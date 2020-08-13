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

    public static boolean checkAge(int age) {
        return age >= 18 && age <= 50;
    }

    public static boolean checkSalary(double salary) {
        return salary > 0;
    }

    public static boolean checkIncreaseSalary(double oldSalary, double newSalary) {
        return newSalary > oldSalary;
    }

    public static boolean checkDecreaseSalary(double oldSalary, double newSalary) {
        return newSalary < oldSalary;
    }

    public static boolean checkStatus(String status) {
        return status.equalsIgnoreCase("UP") || status.equalsIgnoreCase("DOWN");
    }
}
