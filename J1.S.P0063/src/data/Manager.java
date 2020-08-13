/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class Manager {

    LinkedList<Person> personList = new LinkedList<>();

    public void inputInfo() {
        String name, address;
        double salary;

        System.out.println("Input Information Of A Person\n");

        name = InputTool.getString("Please input name: ", "Field required.");
        address = InputTool.getString("Please input address: ", "Field required.");
        do {
            salary = InputTool.getADouble("Please input salary: ", "Please input again.");
            if (salary < 0) {
                System.out.println("Salary must be greater than zero.");
            } else {
                break;
            }
        } while (true);

        personList.add(new Person(name, address, salary));

    }

    public void displayInfo() {
        Collections.sort(personList);
        for (Person p : personList) {
            System.out.println("Information of person you have entered");
            System.out.println("Name: " + p.getName());
            System.out.println("Address: " + p.getAddress());
            System.out.println("Salary: " + p.getSalary());
            System.out.println();
        }
    }

    private void displayInfo(ArrayList<Person> arr) {
        if (arr == null) {
            System.out.println("Can't sort person.");
            return;
        }
        for (Person p : arr) {
            System.out.println("Information of person you have entered");
            System.out.println("Name: " + p.getName());
            System.out.println("Address: " + p.getAddress());
            System.out.println("Salary: " + p.getSalary());
            System.out.println();
        }
    }

    private void swap(PersonWrapper pw1, PersonWrapper pw2) {
        Person tmp = pw1.p;
        pw1.p = pw2.p;
        pw2.p = tmp;
    }

    private ArrayList sortBySalary() {
        try {
            ArrayList<Person> arr = new ArrayList<>();
            Person tmp;

            //copy array
            for (Person p : personList) {
                arr.add(p);
            }

            //bubble sort
            for (int i = 0; i < arr.size() - 1; i++) {
                for (int j = 1; j < arr.size(); j++) {
                    if (arr.get(j).getSalary() > arr.get(j + 1).getSalary()) {
                        PersonWrapper pw1 = new PersonWrapper(arr.get(j));
                        PersonWrapper pw2 = new PersonWrapper(arr.get(j + 1));
                        swap(pw1, pw2);
                    }
                }
            }

            return arr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sort() {
        if (personList.size() < 3) {
            System.out.println("There aren't enough people to sort.");
            return;
        }
        displayInfo(sortBySalary());
    }

}
