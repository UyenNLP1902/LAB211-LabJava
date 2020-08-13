/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Collections;
import java.util.LinkedList;
import util.InputTool;
import util.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    LinkedList<Student> studentList = new LinkedList<>();

    public void inputStudent() {
        String name, classes;
        double mark;

        while (true) {
            name = InputTool.getString("Name: ", "Error!");
            classes = InputTool.getString("Classes: ", "Error!");

            do {
                mark = InputTool.getADouble("Mark: ", "Error!");
                if (!Validation.checkMark(mark))
                    System.out.println("Mark must be bigger than 0 and lower than 10.");
            } while (!Validation.checkMark(mark));

            studentList.add(new Student(name, classes, mark));

            if (!Validation.checkYN("Do you want to enter more student information? (Y/N): ", "Error!")) {
                return;
            }
        }
    }

    private LinkedList sortStudent(LinkedList<Student> inputList) {
        Collections.sort(inputList);
        return inputList;
    }

    private void displayStudent(LinkedList<Student> inputList) {
        int count = 1;
        Collections.sort(inputList);
        for (Student s : inputList) {
            System.out.println("----------Student " + count + "----------");
            System.out.println("Name: " + s.getName());
            System.out.println("Classes: " + s.getClasses());
            System.out.println("Mark: " + s.getMark());
            count++;
        }
    }

    public void displayStudent() {
        displayStudent(studentList);
    }
}
