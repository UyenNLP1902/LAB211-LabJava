/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidatesmanagement;

import data.Manager;
import ui.Menu;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class CandidatesManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("CANDIDATE MANAGEMENT SYSTEM");

        menu.addNewOption("Create Experience");
        menu.addNewOption("Create Fresher");
        menu.addNewOption("Create Internship");
        menu.addNewOption("Searching");
        menu.addNewOption("Show all candidates");
        menu.addNewOption("Exit Program");

        Manager mng = new Manager();
        int choice;
        boolean check;
        do {
            menu.printMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    while (true) {
                        mng.addExperience();
                        if (!Validation.checkYN("Do you want to continue? (Y/N): ", "Error!"))
                            break;
                    }
                    break;
                case 2:
                    while (true) {
                        mng.addFresher();
                        if (!Validation.checkYN("Do you want to continue? (Y/N): ", "Error!"))
                            break;
                    }
                    break;
                case 3:
                    while (true) {
                        mng.addInternship();
                        if (!Validation.checkYN("Do you want to continue? (Y/N): ", "Error!"))
                            break;
                    }
                    break;
                case 4:
                    while (true) {
                        mng.searchCandidate();
                        if (!Validation.checkYN("Do you want to continue? (Y/N): ", "Error!"))
                            break;
                    }
                    break;
                case 5:
                    mng.printAllCandidates();
                    break;
                default:
                    break;
            }
        } while (choice != 6);
        System.out.println("Goodbye!");
    }
}
