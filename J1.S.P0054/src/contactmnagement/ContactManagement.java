/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmnagement;

import data.Manager;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class ContactManagement {
    
    public static void main(String[] args) {
        Menu menu = new Menu("Contact Management Program");
        menu.addNewOption("Add a contact");
        menu.addNewOption("Display all contacts");
        menu.addNewOption("Delete a contact");
        menu.addNewOption("Exit");
        
        Manager mng = new Manager();
        int choice;
        
        do {            
            menu.printMenu();
            choice = menu.getChoice();
            
            switch (choice) {
                case 1: 
                    mng.addContact();
                    break;
                case 2:
                    mng.displayAllContacts();
                    break;
                case 3:
                    mng.deleteContact();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please choose again");
                    break;
            }
            
        } while (choice != 4);
        
        System.out.println("Goodbye!");
        
    }
}
