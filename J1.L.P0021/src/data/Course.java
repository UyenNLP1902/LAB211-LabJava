/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author SE140355
 */
public class Course {

    private String courseName;
    private ArrayList<Integer> semester = null;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Integer> getSemester() {
        return semester;
    }

    public void setSemester(ArrayList<Integer> semester) {
        this.semester = semester;
    }

    public void addSemester(int semester) {
        if (!this.semester.contains(semester)) {
            this.semester.add(semester);
        } else {
            System.out.println("You've already enrolled this course in this semester.");
        }
    }
}
