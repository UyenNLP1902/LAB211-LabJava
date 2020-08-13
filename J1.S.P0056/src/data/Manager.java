/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    ArrayList<Worker> workerList = new ArrayList<>();
    ArrayList<UpdateHistory> historyList = new ArrayList<>();

    private boolean isExistID(String id) {
        if (workerList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < workerList.size(); i++) {
            if (workerList.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private Worker getWorkerObject(String id) {
        if (workerList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < workerList.size(); i++) {
            if (workerList.get(i).getId().equalsIgnoreCase(id)) {
                return workerList.get(i);
            }
        }
        return null;
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //----------------------------------------------------------------
    public void addWorker() {
        String id, name, workLocation;
        int age;
        double salary;

        while (true) {
            System.out.println();
            do {
                id = InputTool.getID("Enter ID: ", "Error!");
                if (isExistID(id)) {
                    System.out.println("This ID is already exist.");
                }
            } while (isExistID(id));

            name = InputTool.getString("Enter name: ", "Error!");

            do {
                age = InputTool.getAnInteger("Enter age: ", "Error!");
                if (!Validation.checkAge(age)) {
                    System.out.println("Age must be between 18 and 50.");
                }
            } while (!Validation.checkAge(age));

            do {
                salary = InputTool.getADouble("Enter salary: ", "Error!");
                if (!Validation.checkSalary(salary)) {
                    System.out.println("Salary must be bigger than 0.");
                }
            } while (!Validation.checkSalary(salary));

            workLocation = InputTool.getString("Enter work location: ", "Error!");

            workerList.add(new Worker(id, name, age, salary, workLocation));
            System.out.println("Added!");

            if (!Validation.checkYN("Do you want to add another worker? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void increaseSalary() {
        String id;
        double oldSalary, newSalary;
        Worker searchWorker, newWorker;

        if (workerList.isEmpty()) {
            System.out.println("There's no worker in the database.");
            return;
        }

        while (true) {

            System.out.println();

            id = InputTool.getID("Enter code: ", "Error!");
            searchWorker = getWorkerObject(id);
            if (searchWorker == null) {
                System.out.println("Cannot find this worker.");
                return;
            }

            newWorker = new Worker(searchWorker);
            oldSalary = newWorker.getSalary();

            do {
                newSalary = InputTool.getADouble("Enter new salary: ", "Error!");
                if (!Validation.checkIncreaseSalary(oldSalary, newSalary)) {
                    System.out.println("New salary must be bigger than current salary.");
                }
            } while (!Validation.checkIncreaseSalary(oldSalary, newSalary));

            searchWorker.setSalary(newSalary);
            newWorker.setSalary(newSalary);

            historyList.add(new UpdateHistory(newWorker, "UP", getCurrentDate()));

            if (!Validation.checkYN("Do you want to continue updating? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void decreaseSalary() {
        String id;
        double oldSalary, newSalary;
        Worker searchWorker, newWorker;

        if (workerList.isEmpty()) {
            System.out.println("There's no worker in the database.");
            return;
        }

        while (true) {
            System.out.println();

            id = InputTool.getID("Enter code: ", "Error!");
            searchWorker = getWorkerObject(id);
            if (searchWorker == null) {
                System.out.println("Cannot find this worker.");
                return;
            }

            newWorker = new Worker(searchWorker);
            oldSalary = newWorker.getSalary();

            do {
                newSalary = InputTool.getADouble("Enter new salary: ", "Error!");
                if (!Validation.checkDecreaseSalary(oldSalary, newSalary)) {
                    System.out.println("New salary must be smaller than current salary.");
                }
            } while (!Validation.checkDecreaseSalary(oldSalary, newSalary));

            searchWorker.setSalary(newSalary);
            newWorker.setSalary(newSalary);

            historyList.add(new UpdateHistory(newWorker, "DOWN", getCurrentDate()));

            if (!Validation.checkYN("Do you want to continue updating? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void printHistory() {
        if (historyList.isEmpty()) {
            System.out.println("There's no update history in the database.");
            return;
        }

        while (true) {
            System.out.println();

            Collections.sort(historyList);

            String header = String.format("%5s | %-10s | %3s | %7s | %6s | %-12s", "ID", "Name", "Age", "Salary", "Status", "Date");
            System.out.println(header);

            for (UpdateHistory history : historyList) {
                history.printHistory();
            }

            System.out.println();
            if (Validation.checkYN("Do you want to return to menu? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

}
