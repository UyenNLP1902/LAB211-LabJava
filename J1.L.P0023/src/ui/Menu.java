/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String newOption) {
        optionList.add(newOption);        
    }
    
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no option");
            return;
        }
        System.out.println("-------------------------------");
        System.out.println("Welcome to " + menuTitle);
        int count = 0;
        for (String x : optionList) {
            count++;
            System.out.println(count + ". " + x);
        }
    }
    
    public int getChoice() {
        int maxOption = optionList.size();
        String inMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You're supposed to choose from 1 to " + maxOption;
        return InputTool.getAnInteger(inMsg, errorMsg, 1, maxOption);
    }
}
