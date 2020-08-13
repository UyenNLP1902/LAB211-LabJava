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
    
    public static boolean checkWeight(double weight) {
        return weight > 0;
    }
    
    public static boolean checkHeight(double height) {
        return height > 0;
    }
    
    public static boolean checkOperator(String operator) {
        if (operator.equalsIgnoreCase("+") 
                || operator.equalsIgnoreCase("-") 
                || operator.equalsIgnoreCase("*") 
                || operator.equalsIgnoreCase("/")
                || operator.equalsIgnoreCase("^")
                || operator.equalsIgnoreCase("="))
            return true;
        return false;
    }
}
