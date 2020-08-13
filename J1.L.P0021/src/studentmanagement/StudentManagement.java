/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import data.Manager;
import ui.Menu;
import uyen.ulti.MyToys;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("Student Management");
        menu.addNewOption("Create a new student");
        menu.addNewOption("Find and sort student");
        menu.addNewOption("Update and delete student");
        menu.addNewOption("Student report");
        menu.addNewOption("Exit program");

        Manager st = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        st.createStudent();
                        if (!Validation.checkYN("Do you want to add more student? (Y/N): ", "Error!")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        st.findAndSort();
                        if (!Validation.checkYN("Do you want to add more student? (Y/N): ", "Error!")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        st.updateAndDelete();
                        if (!Validation.checkYN("Do you want to continue update and delete? (Y/N): ", "Error!")) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        st.showReport();
                        if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Enter again: ");
                    break;
            }
        } while (choice != 5);
    }

}
