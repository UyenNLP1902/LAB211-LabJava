/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

import data.Manager;
import ui.Menu;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class DoctorManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Doctor Management");
        menu.addNewOption("Add a new doctor");
        menu.addNewOption("Update doctor");
        menu.addNewOption("Delete doctor");
        menu.addNewOption("Search doctor");
        menu.addNewOption("Exit program");

        Manager mng = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    mng.addDoctor();
                    if (Validation.checkYN() == false) {
                        choice = 5;
                    }
                    break;
                case 2:
                    mng.updateDoctor();
                    if (Validation.checkYN() == false) {
                        choice = 5;
                    }
                    break;
                case 3:
                    mng.deleteDoctor();
                    if (Validation.checkYN() == false) {
                        choice = 5;
                    }
                    break;
                case 4:
                    mng.searchDoctor();
                    if (Validation.checkYN() == false) {
                        choice = 5;
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter again: ");
                    break;
            }
        } while (choice != 5);
        System.out.println("Goodbye!");
    }

}
