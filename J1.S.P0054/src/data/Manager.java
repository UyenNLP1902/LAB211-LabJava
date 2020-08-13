/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.StringTokenizer;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact() {
        String errorMsg = "Error!";
        String name, group, address, phone;
        String firstName = null, lastName = null;
        int id;
        String idString;

        while (true) {
            id = contactList.size() + 1;
            idString = Integer.toString(id);

            name = InputTool.getString("Name: ", errorMsg);
            group = InputTool.getString("Group: ", errorMsg);
            address = InputTool.getString("Address: ", errorMsg);

            do {
                phone = InputTool.getString("Phone: ", errorMsg);
                if (!Validation.checkPhone(phone)) {
                    printPhoneMenu();
                }
            } while (!Validation.checkPhone(phone));

            StringTokenizer stk = new StringTokenizer(name);
            firstName = stk.nextToken().trim();
            lastName = (stk.nextToken().trim() + " ");
            while (stk.hasMoreTokens()) {
                lastName += (stk.nextToken() + " ");
            }

            contactList.add(new Contact(idString, name, firstName, lastName, group, address, phone));

            System.out.println("Added successfully!");

            if (!Validation.checkYN("Do you want to add more contact? (Y/N): ", errorMsg)) {
                break;
            }
        }
    }

    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("There's no contact yet.");
            return;
        }
        while (true) {
            String header = String.format("%5s | %-20s | %-12s | %-15s | %-8s | %-8s | %-21s", "ID", "Fullname", "First Name", "Last Name", "Group", "Address", "Phone");
            System.out.println(header);

            for (Contact contact : contactList) {
                contact.showContactInfo();
            }

            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }
    }
    
    public void deleteContact() {
        if (contactList.isEmpty()) {
            System.out.println("There's no contact yet");
            return;
        }
        
        int id, pos;
        String idString;
        
        while (true) {            
            id = InputTool.getAnInteger("Enter ID: ", "ID is digit");
            idString = Integer.toString(id);
            
            pos = searchContactObjectById(idString);
            
            if (pos == -1) {
                System.out.println("Cannot find this contact!");
            } else {
                contactList.remove(pos);
                System.out.println("Deleted successfully!");
            }
            
            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    //--------------------------------------------------------------------------
    private void printPhoneMenu() {
        System.out.println("Please input phone flow");
        System.out.println("• 1234567890");
        System.out.println("• 123-456-7890");
        System.out.println("• 123-456-7890 x1234");
        System.out.println("• 123-456-7890 ext1234");
        System.out.println("• (123)-456-7890");
        System.out.println("• 123.456.7890");
        System.out.println("• 123 456 7890");
    }

    private int searchContactObjectById(String id) {
        if (contactList.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

}
