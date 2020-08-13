/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import data.Manager;
import java.io.IOException;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class UserManagement {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu("User Management System");
        menu.addNewOption("Create a new account");
        menu.addNewOption("Login");
        menu.addNewOption("Exit");

        Manager mng = new Manager();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    mng.addAccount();
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
