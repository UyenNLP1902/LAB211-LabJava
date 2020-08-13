/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engvietdictionary;

import data.Translator;
import java.io.IOException;
import ui.Menu;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class EngVietDictionary {

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu("Vietnamese-English Dictionary");
        menu.addNewOption("1. Add word.");
        menu.addNewOption("2. Delete word.");
        menu.addNewOption("3. Translate");
        menu.addNewOption("4. Quit.");

        Translator ts = new Translator();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    ts.addWord();
                    ts.saveFile();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 2:
                    ts.removeWord();
                    ts.saveFile();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 3:
                    ts.translate();
                    if (Validation.checkYN() == false) {
                        choice = 4;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please choose again.");
            }
        } while (choice != 4);

        System.out.println("Goodbye!");

    }

}
