/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    LinkedList<Doctor> doctorList = new LinkedList<>();

    private int searchDoctorByCode(String code) {
        if (doctorList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    private Doctor searchDoctorObjectByCode(String DoctorID) {
        if (doctorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getCode().equalsIgnoreCase(DoctorID)) {
                return doctorList.get(i);
            }
        }
        return null;
    }

    public void addDoctor() {
        String code, name, specialization;
        int availability, exist;

        do {
            code = InputTool.getCode("Please input doctor's code: ", "Error occured! Please input again.");
            exist = searchDoctorByCode(code);
            if (exist >= 0) {
                System.out.println("This code is already exist!");
            }
        } while (exist != -1);

        name = InputTool.getString("Please input doctor's name: ", "Error occured! Please input again.");
        specialization = InputTool.getString("Please input doctor's specialization: ", "Error occured! Please input again.");
        do {
            availability = InputTool.getAnInteger("Please input doctor's availability: ", "Error occured! Please input again.");
            if (!Validation.checkAvailability(availability)) {
                System.out.println("Availability must be bigger than 0.");
            }
        } while (!Validation.checkAvailability(availability));

        doctorList.add(new Doctor(code, name, specialization, availability));
        System.out.println("Added successfully!");
    }

    public void updateDoctor() {
        String code;
        Doctor d;

        code = InputTool.getCode("Please input doctor's code: ", "Error occured! Please input again.");
        d = searchDoctorObjectByCode(code);

        if (d == null) {
            System.out.println("No doctor found!");
            return;
        }

        System.out.println("Old profile");
        d.showProfile();

        //updates
        int choice = Validation.checkUpdateChoice();
        String name, specialization;
        int availability;

        switch (choice) {
            case 1:
                name = InputTool.getString("Please input doctor's name: ", "Error occured! Please input again.");
                d.setName(name);
                break;
            case 2:
                specialization = InputTool.getString("Please input doctor's specialization: ", "Error occured! Please input again.");
                d.setSpecialization(specialization);
                break;
            case 3:
                do {
                    availability = InputTool.getAnInteger("Please input doctor's availability: ", "Error occured! Please input again.");
                    if (!Validation.checkAvailability(availability)) {
                        System.out.println("Availability must be bigger than 0.");
                    }
                } while (!Validation.checkAvailability(availability));
                d.setAvailability(availability);
                break;
            default:
                break;
        }
        System.out.println("Update successfully!");
    }

    public void deleteDoctor() {
        String code;
        Doctor d;

        code = InputTool.getCode("Please input doctor's code: ", "Error occured! Please input again.");
        d = searchDoctorObjectByCode(code);

        if (d == null) {
            System.out.println("No doctor found!");
            return;
        }

        System.out.println("Doctor's profile");
        d.showProfile();

        if (Validation.checkDelete()) {
            doctorList.remove(d);
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Canceled!");
        }
    }

    public void searchDoctor() {
        LinkedList<Doctor> foundList = new LinkedList<>();
        String searchString = InputTool.getString("Enter Doctor's name you want to find: ", "Error occured. Please input again: ");

        for (Doctor d : doctorList) {
            if (d.getName().contains(searchString)) {
                foundList.add(d);
            }
        }
        if (foundList.isEmpty()) {
            System.out.println("Cannot find.");
            return;
        }
        Collections.sort(foundList);
        System.out.println("List: ");
        for (Doctor f : foundList) {
            f.showProfile();
        }
    }
}
