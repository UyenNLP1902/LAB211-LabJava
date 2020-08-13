/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personmanagement;

import data.Manager;
import ui.Menu;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class PersonManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Person Management");
        menu.addNewOption("Input information");
        menu.addNewOption("Display all information");
        menu.addNewOption("Sort and display all information by salary");
        menu.addNewOption("Exit program");

        Manager st = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    st.inputInfo();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 2:
                    st.displayInfo();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 3:
                    st.sort();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter again: ");
                    break;
            }
        } while (choice != 4);
        System.out.println("Goodbye!");
    }

}
