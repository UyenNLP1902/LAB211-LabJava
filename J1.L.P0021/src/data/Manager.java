/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import uyen.ulti.MyToys;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    private ArrayList<Student> studentList = new ArrayList<>();

    private int searchStudentByID(String id) {
        if (studentList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    private Student searchStudentObjectByID(String studentID) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(studentID)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    private boolean checkNumberOfStudent() {
        if (studentList.size() < 2) {
            return false;
        }
        return true;
    }

    public void createStudent() {
        if (studentList.size() >= 10) {
            if (!Validation.checkYN("Do you want to add more student? (Y/N): ", "Error occured. Please input again.")) {
                return;
            }
        }

        String id, name, course;
        int exist, semester;

        do {
            id = MyToys.getID("Please input student's ID: ", "Error occured. Please input again: ");
            exist = searchStudentByID(id);
            if (exist >= 0) {
                System.out.println("This ID is already exist!");
            }
        } while (exist != -1);

        name = MyToys.getString("Please input student's name: ", "Error occured. Please input again: ");
        studentList.add(new Student(id, name));

        while (true) {
            semester = MyToys.getAnInteger("Please input semester: ", "Error ocurred. Please input again: ");
            
            System.out.println("There's only 3 course available: \n"
                    + "\t1. Java"
                    + "\t2. C/C++"
                    + "\t3. .Net");
            course = Validation.getCourse("Input course: ", "Error!");

            studentList.get(studentList.size() - 1).addCourse(semester, course);

            if (!Validation.checkYN("Do you want to continue adding semester and course? (Y/N): ", "Error!")) {
                break;
            }
        }

        System.out.println("Added successfully");
    }

    public void findAndSort() {
        boolean check = checkNumberOfStudent();
        if (check == false) {
            System.out.println("This function requires at least 2 students in the list.");
            return;
        }

        ArrayList<Student> foundList = new ArrayList<>();
        String searchString = MyToys.getString("Enter student's name you want to find: ", "Error occured. Please input again: ");

        for (Student x : studentList) {
            if (x.name.contains(searchString)) {
                foundList.add(x);
            }
        }

        Comparator nameBalance = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        Collections.sort(foundList, nameBalance);
        System.out.println("List: ");
        for (Student f : foundList) {
            f.showInfoInSearch();
        }
    }

    private void updateStudent(Student x) {
        boolean valid;
        String name, course;
        int choice, semester;
        while (true) {
            choice = Validation.checkUpdateChoice();
            switch (choice) {
                case 1:
                    name = MyToys.getString("Enter new name: ", "Error occured. Please input again: ");
                    x.setName(name);
                    break;
                case 2:
                    semester = MyToys.getAnInteger("Enter semester: ", "Error!");
                    do {
                        course = MyToys.getString("Please input course name: ", "Error occured. Please input again: ");
                        if (!Validation.checkCourseValidation(course)) {
                            System.out.println("Wrong course name!");
                        }
                    } while (!Validation.checkCourseValidation(course));

                    x.addCourse(semester, course);
                    System.out.println("Added successfully.");
                    break;

                case 3:
                    semester = MyToys.getAnInteger("Enter semester: ", "Error!");
                    do {
                        course = MyToys.getString("Please input course name: ", "Error occured. Please input again: ");
                        if (!Validation.checkCourseValidation(course)) {
                            System.out.println("Wrong course name!");
                        }
                    } while (!Validation.checkCourseValidation(course));
                    x.removeCourse(semester, course);
                    break;

                default:
                    break;
            }
            System.out.println("Update successfully!");
            if (!Validation.checkYN("Do you want to continue updating? (Y/N): ", "Error.")) {
                break;
            }
        }
    }

    private void deleteStudent(Student x) {
        studentList.remove(x);
        System.out.println("Delete successfully!");
    }

    public void updateAndDelete() {
        boolean check = checkNumberOfStudent();
        if (check == false) {
            System.out.println("This function requires at least 2 students in the list.");
            return;
        }

        String id;
        Student x;

        id = MyToys.getString("Input student's id: ", "Error occured. Please input again: ");
        x = searchStudentObjectByID(id);

        if (x == null) {
            System.out.println("No student found!");
            return;
        }

        System.out.println("Old profile: ");
        x.showFullInfo();

        boolean ud = Validation.checkUD();

        if (ud == true) {
            updateStudent(x);
            return;
        }

        if (ud == false) {
            deleteStudent(x);
            return;
        }
    }

    public void showReport() {
        boolean check = checkNumberOfStudent();
        if (check == false) {
            System.out.println("This function requires at least 2 students in the list.");
            return;
        }

        Collections.sort(studentList);
        for (Student x : studentList) {
            for (Course c : x.getCourseList()) {
                x.showFullInfo();
            }
        }
    }
}
