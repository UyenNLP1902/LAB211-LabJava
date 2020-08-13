/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorprogram;

import data.Calculator;
import ui.Menu;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class CaculatorProgram {

    public static void main(String[] args) {
        Menu menu = new Menu("Calculator Program");
        menu.addNewOption("Normal Calculator");
        menu.addNewOption("BMI Calculator");
        menu.addNewOption("Exit");

        int choice;
        Calculator cal = new Calculator();
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("------------");
                        cal.calculateNumber();
                        if (Validation.checkYN() == false) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("------------");
                        cal.calculateBMI();
                        if (Validation.checkYN() == false) {
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please choose again.");
                    break;
            }
        } while (choice != 3);

        System.out.println("Goodbye!");
    }
}
