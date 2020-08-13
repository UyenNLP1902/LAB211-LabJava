/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private Hashtable<String, ArrayList<Fruit>> orderList = new Hashtable<>();

    private boolean isExistID(String id, ArrayList<Fruit> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public Fruit searchFruitObject(String fruitId, ArrayList<Fruit> list) {
        if (list.isEmpty()) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(fruitId)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void addFruit() {
        String id, name, origin;
        double price;
        int quantity;

        while (true) {
            do {
                id = InputTool.getID("Fruit ID: ", "Error!");
                if (isExistID(id, fruitList)) {
                    System.out.println("This ID is already exist.");
                }
            } while (isExistID(id, fruitList));

            name = InputTool.getString("Fruit name: ", "Error!");
            origin = InputTool.getString("Origin: ", "Error!");

            do {
                price = InputTool.getAnDouble("Price: ", "Error!");
                if (!Validation.checkPrice(price)) {
                    System.out.println("Price must be a positive number.");
                }
            } while (!Validation.checkPrice(price));

            do {
                quantity = InputTool.getAnInteger("Quantity: ", "Error!");
                if (!Validation.checkQuantity(quantity)) {
                    System.out.println("Quantity must be a positive integer.");
                }
            } while (!Validation.checkQuantity(quantity));

            fruitList.add(new Fruit(id, name, price, quantity, origin));

            if (!Validation.checkYN("Do you want to add more fruits? (Y/N): ", "Error!")) {
                break;
            }
        }

        Collections.sort(fruitList);

        String header = String.format("%3s | %-10s | %-10s | %5s | %10s", "ID", "Name", "Origin", "Price", "Quantity");
        System.out.println(header);

        for (Fruit fruit : fruitList) {
            fruit.showFullDetail();
        }
    }

    public void shopping() {
        if (fruitList.isEmpty()) {
            System.out.println("There's currently no pruduct in the shop.");
            return;
        }

        shopping(fruitList);
    }

    private void shopping(ArrayList<Fruit> shoppingList) {
        String customerName;
        ArrayList<Fruit> cart;

        String header = String.format("%5s | %-10s | %-10s | %5s  | %10s", "Item", "Name", "Origin", "Price", "Quantity");
        System.out.println(header);
        for (int i = 0; i < shoppingList.size(); i++) {
            shoppingList.get(i).showGroceries(i + 1);
        }

        cart = getOrderedFruitList(shoppingList);

        Comparator nameBalance = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                return f1.getName().compareToIgnoreCase(f2.getName());
            }
        };

        Collections.sort(cart, nameBalance);

        System.out.println("------------------");
        String subHeader = String.format("%10s | %10s | %7s | %8s", "Product", "Quantity", "Price", "Amount");
        System.out.println(subHeader);

        double total = 0;
        for (Fruit fruit : cart) {
            fruit.printOrderedProduct();
            total += (fruit.getPrice() * fruit.getQuantity());
        }

        System.out.println("Total: " + total + "$");

        customerName = InputTool.getString("\nInput your name: ", "Error!");

        orderList.put(customerName, cart);
    }

    private ArrayList<Fruit> getOrderedFruitList(ArrayList<Fruit> fruitList) {
        ArrayList<Fruit> shoppingCart = new ArrayList<>();
        int choice, quantity = 0;
        Fruit tmpFruit = null, foundFruit;

        while (true) {

            //find specific fruit
            while (true) {
                do {
                    choice = InputTool.getAnInteger("Choose a fruit to buy (input number): ", "Error!");
                    if (!Validation.checkBuyFruit(choice, fruitList)) {
                        System.out.println("Cannot find this fruit.");
                    }
                } while (!Validation.checkBuyFruit(choice, fruitList));

                foundFruit = fruitList.get(choice - 1);

                System.out.println("You selected: " + fruitList.get(choice - 1).getName());

                //check if it's already in the shooping cart
                if (isExistID(foundFruit.getId(), shoppingCart)) {
                    System.out.println("You've already bought this product.");
                    if (!Validation.checkChosenFruit("Please press any key to choose another fruit or press F to finish shopping: ", "Error!")) {
                        return shoppingCart;
                    }
                } else if (foundFruit.getQuantity() == 0) {
                    System.out.println("Out of stock!");
                    if (!Validation.checkChosenFruit("Please press any key to choose another fruit or press F to finish shopping: ", "Error!")) {
                        return shoppingCart;
                    }
                } else {
                    break;      //haven't bought
                }
            }

            tmpFruit = new Fruit(fruitList.get(choice - 1));

            //input quantity
            do {
                quantity = InputTool.getAnInteger("Please input quantity: ", "Error!");
                if (!Validation.checkQuantity(quantity) || !Validation.checkBoughtQuantity(quantity, foundFruit.getQuantity())) {
                    System.out.println("Invalid quantity.");
                }
            } while (!Validation.checkQuantity(quantity) || !Validation.checkBoughtQuantity(quantity, foundFruit.getQuantity()));
            foundFruit.updateStockQuantity(quantity);

            //refresh
            tmpFruit.setQuantity(quantity);
            shoppingCart.add(tmpFruit);

            //continue
            if (Validation.checkYN("Do you want to finish your order? (Y/N): ", "Error!")) {
                break;
            }

        }
        return shoppingCart;
    }

    public void viewOrders() {
        if (orderList.isEmpty()) {
            System.out.println("There's no customer yet.");
            return;
        }

        String header = String.format("%10s | %10s | %7s | %8s", "Product", "Quantity", "Price", "Amount");

        for (Map.Entry<String, ArrayList<Fruit>> entry : orderList.entrySet()) {
            int total = 0;

            System.out.println("Customer: " + entry.getKey());

            System.out.println(header);

            for (Fruit fruit : entry.getValue()) {
                fruit.printOrderedProduct();
                total += (fruit.getPrice() * fruit.getQuantity());
            }
            System.out.println("Total: " + total + "$\n");

        }
    }
}
