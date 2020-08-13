/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitshop;

import data.Manager;
import ui.Menu;

/**
 *
 * @author SE140355
 */
public class FruitShop {

    public static void main(String[] args) {
        Menu menu = new Menu("Fruit Shop System");
        menu.addNewOption("Create Fruit");
        menu.addNewOption("View Orders");
        menu.addNewOption("Shopping (for buyers)");
        menu.addNewOption("Exit");

        Manager mng = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    mng.addFruit();
                    break;
                case 2:
                    mng.viewOrders();
                    break;
                case 3: 
                    mng.shopping();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        } while (choice != 4);
        System.out.println("Goodbye!");
    }
}
