/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import data.Manager;
import ui.Menu;
import util.Validation;

/**
 *
 * @author SE140355
 */
public class StudentManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Collection Sort Program");
        menu.addNewOption("Add student");
        menu.addNewOption("Display student information");
        menu.addNewOption("Exit");

        Manager mng = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    mng.inputStudent();
                    break;
                case 2:
                    mng.displayStudent();
                    if (!Validation.checkYN("Do you want to continue? (Y/N): ", "Error!")) {
                        choice = 3;
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please input again");
                    break;
            }

        } while (choice != 3);
        System.out.println("Goodbye!");
    }
}
