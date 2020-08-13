/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement;

import data.Manager;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class AccountManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Login Program");
        menu.addNewOption("Add user");
        menu.addNewOption("Login");
        menu.addNewOption("Exit");

        int choice;
        Manager mng = new Manager();

        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    mng.addUser();
                    break;
                case 2:
                    mng.login();
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
