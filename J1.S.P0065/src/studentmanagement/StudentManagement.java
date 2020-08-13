/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import data.Student;
import data.Manager;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class StudentManagement {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Manager mng = new Manager();
        while (true) {
            System.out.println("====== Management Student Program ======");

            while (true) {
                mng.createStudent(studentList);

                if (!Validation.checkYN("Do you want to add more student? (Y/N): ", "Error!")) {
                    break;
                }
            }

            mng.showInfo(studentList);
            mng.getPercentTypeStudent(studentList);
            
            if (!Validation.checkYN("Do you want to add more student? (Y/N): ", "Error!"))
                break;
        }
        
        System.out.println("Goodbye!");
    }
}
