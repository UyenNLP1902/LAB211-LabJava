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
public class Calculator {

    private double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    private String printStatus(double bmi) {
        if (bmi < 19) {
            return "UNDER-STANDARD";
        }
        if (bmi >= 19 && bmi < 25) {
            return "STANDARD";
        }
        if (bmi >= 25 && bmi < 30) {
            return "OVERWEIGHT";
        }
        if (bmi >= 30 && bmi < 40) {
            return "FAT - should lose weight";
        }
        if (bmi >= 40) {
            return "VERY FAT - should lose weight immediately";
        }
        return null;
    }

    public void calculateBMI() {
        double weight, height;

        do {
            weight = InputTool.getADouble("Enter weight (kg): ", "BMI is digit");
            if (weight < 0) {
                System.out.println("Weight must be bigger than 0");
            }
        } while (!Validation.checkWeight(weight));
        do {
            height = InputTool.getADouble("Enter height (m): ", "BMI is digit");
            if (height < 0) {
                System.out.println("Height must be bigger than 0");
            }
        } while (!Validation.checkHeight(height));

        double bmi = calculateBMI(weight, height);
        System.out.println("BMI Number: " + bmi);
        System.out.println("BMI Status: " + printStatus(bmi));
    }

    //--------------------------------------------------
    private double calculateNumber(double firstNumber, String operator, double secondNumber) {
        if (operator.equalsIgnoreCase("+")) {
            return firstNumber + secondNumber;
        }
        if (operator.equalsIgnoreCase("-")) {
            return firstNumber - secondNumber;
        }
        if (operator.equalsIgnoreCase("*")) {
            return firstNumber * secondNumber;
        }
        if (operator.equalsIgnoreCase("/")) {
            return firstNumber / secondNumber;
        }
        if (operator.equalsIgnoreCase("^")) {
            return Math.pow(firstNumber, secondNumber);
        }
        return -1;
    }

    public void calculateNumber() {
        double number, memory = 0;
        String operator;
        number = InputTool.getADouble("Enter number: ", "Error! Please enter again.");
        memory += number;
        while (true) {
            //gets operator
            do {
                operator = InputTool.getString("Enter operator: ", "Error! Please enter again");
            } while (!Validation.checkOperator(operator));

            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                break;
            }
            //get another number
            while (true) {
                number = InputTool.getADouble("Enter number: ", "Error! Please enter again.");
                //prevents divide by 0
                if (operator.equalsIgnoreCase("/") && number == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    break;
                }
            }

            //calculates
            memory = calculateNumber(memory, operator, number);
            System.out.println("Memory: " + memory);

        }
    }
}
