/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workermanagement;

import data.Manager;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class WorkerManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Worker Management");
        menu.addNewOption("Add worker");
        menu.addNewOption("Up salary");
        menu.addNewOption("Down salary");
        menu.addNewOption("Display update history");
        menu.addNewOption("Exit");

        Manager mng = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    mng.addWorker();
                    break;
                case 2:
                    mng.increaseSalary();
                    break;
                case 3:
                    mng.decreaseSalary();
                    break;
                case 4:
                    mng.printHistory();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please input again!");
                    break;
            }
        } while (choice != 5);
        System.out.println("Goodbye!");
    }
}
