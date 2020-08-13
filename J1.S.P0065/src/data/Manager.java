/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    public void createStudent(ArrayList<Student> list) {
        String name, classes;
        double maths, physics, chemistry;

        name = InputTool.getString("Name: ", "Error!");
        classes = InputTool.getString("Class: ", "Error!");

        do {
            maths = InputTool.getADouble("Maths: ", "Maths is digit.");
            if (Validation.checkMark(maths) < 0) {
                System.out.println("Maths is greater than or equal 0");
            }
            if (Validation.checkMark(maths) > 0) {
                System.out.println("Maths is less than or equal 10");
            }
        } while (Validation.checkMark(maths) != 0);

        do {
            chemistry = InputTool.getADouble("Chemistry: ", "Chemistry is digit.");
            if (Validation.checkMark(chemistry) < 0) {
                System.out.println("Chemistry is greater than or equal 0");
            }
            if (Validation.checkMark(chemistry) > 0) {
                System.out.println("Chemistry is less than or equal 10");
            }
        } while (Validation.checkMark(chemistry) != 0);

        do {
            physics = InputTool.getADouble("Physics: ", "Physics is digit.");
            if (Validation.checkMark(physics) < 0) {
                System.out.println("Physics is greater than or equal 0");
            }
            if (Validation.checkMark(physics) > 0) {
                System.out.println("Physics is less than or equal 10");
            }
        } while (Validation.checkMark(physics) != 0);

        list.add(new Student(name, classes, maths, physics, chemistry));
        System.out.println("Added!");
    }

    public void showInfo(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).showInfo(i);
        }
    }

    public void getPercentTypeStudent(ArrayList<Student> list) {
        int a = 0, b = 0, c = 0, d = 0;
        int totalStudent = list.size();
        for (Student student : list) {
            if (student.getType().equalsIgnoreCase("A")) {
                a++;
            } else if (student.getType().equalsIgnoreCase("B")) {
                b++;
            } else if (student.getType().equalsIgnoreCase("C")) {
                c++;
            } else {
                d++;
            }
        }

        System.out.println("------ Classification Info ------");
        System.out.printf("A: %f", calcPercent(a, totalStudent));
        System.out.printf("B: %f", calcPercent(b, totalStudent));
        System.out.printf("C: %f", calcPercent(c, totalStudent));
        System.out.printf("D: %f", calcPercent(d, totalStudent));
    }
    
    private double calcPercent(int n, int total) {
        return (double)n / (double)total * 100;
    }
}
