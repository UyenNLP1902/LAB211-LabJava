/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebasenumbersystem;

import data.Manager;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class ChangeBaseNumberSystem {
    
    public static void main(String[] args) {
        Menu menu = new Menu("Change Base Number System");
        menu.addNewOption("Convert from Binary");
        menu.addNewOption("Convert from Decimal");
        menu.addNewOption("Convert from Hexadecimal");
        menu.addNewOption("Exit");
        
        int choice;
        Manager mng = new Manager();
        do {            
            menu.printMenu();
            choice = menu.getChoice();
            
            switch(choice) {
                case 1:
                    mng.convertFromBinary();
                    break;
                case 2:
                    mng.convertFromDecimal();
                    break;
                case 3:
                    mng.convertFromHexadecimal();
                    break;
                default:
                    break;
            }
            
        } while (choice != 4);
        System.out.println("Goodbye!!");
    }
}
