/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.util.ArrayList;
import data.Fruit;

/**
 *
 * @author SE140355
 */
public class Validation {

    public static boolean checkYN(String inMsg, String errorMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N only.");
        }
    }

    public static boolean checkUpdateQuantityChoice(String inMsg, String errorMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("A")) {
                return true;
            }

            if (result.equalsIgnoreCase("R")) {
                return false;
            }
            System.out.println("Please input a/A or r/R only.");
        }
    }

    public static boolean checkChosenFruit(String inMsg, String errorMsg) {
        while (true) {
            String result = InputTool.getString(inMsg, errorMsg);
            if (result.equalsIgnoreCase("F")) {
                return false;
            } else {
                return true;
            }

        }
    }

    public static boolean checkPrice(double price) {
        return price > 0;
    }

    public static boolean checkQuantity(int quantity) {
        return quantity > 0;
    }

    public static boolean checkBuyFruit(int choice, ArrayList<Fruit> fruitList) {
        return choice > 0 && choice <= fruitList.size();
    }
    
    public static boolean checkBoughtQuantity(int bought, int stock) {
        return bought <= stock;
    }
}
