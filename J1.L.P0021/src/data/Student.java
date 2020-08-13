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
public class Student implements Comparable<Student> {

    protected String id;
    protected String name;
    protected ArrayList<Course> courseList = new ArrayList<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        courseList.add(new Course("Java"));
        courseList.add(new Course(".Net"));
        courseList.add(new Course("C/C++"));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(int semester, String courseName) {
        switch (courseName) {
            case "Java":
                courseList.get(0).addSemester(semester);
                break;
            case "C/C++":
                courseList.get(1).addSemester(semester);
                break;
            case ".Net":
                courseList.get(2).addSemester(semester);
                break;
        }
    }

    public void showInfoInSearch() {
        for (Course c : courseList) {
            if (!c.getSemester().isEmpty()) {
                System.out.printf("%-15s | %7s | ", name,
                        c.getCourseName());
                for (int s : c.getSemester()) {
                    System.out.print(s + ", ");
                }
                System.out.println();
            }
        }
    }

    public void showFullInfo() {
        for (Course c : courseList) {
            if (!c.getSemester().isEmpty()) {
                String msg;
                msg = String.format("&-10s | %-15s | %7s | %5d", id, name,
                        c.getCourseName(), c.getSemester().size());
                System.out.println(msg);
            }
        }
    }

    public void removeCourse(int semester, String courseName) {
        switch (courseName) {
            case "Java":
                if (courseList.get(0).getSemester().contains(semester)) {
                    int i = courseList.get(0).getSemester().indexOf(semester);
                    courseList.get(0).getSemester().remove(i);
                    System.out.println("Removed successful");
                } else {
                    System.out.println("This semester don't have this course.");
                }
                break;
            case ".Net":
                if (courseList.get(1).getSemester().contains(semester)) {
                    int i = courseList.get(1).getSemester().indexOf(semester);
                    courseList.get(1).getSemester().remove(i);
                    System.out.println("Removed successful");
                } else {
                    System.out.println("This semester don't have this course.");
                }
                break;
            case "C/C++":
                if (courseList.get(2).getSemester().contains(semester)) {
                    int i = courseList.get(2).getSemester().indexOf(semester);
                    courseList.get(2).getSemester().remove(i);
                    System.out.println("Removed successful");
                } else {
                    System.out.println("This semester don't have this course.");
                }
                break;
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareToIgnoreCase(o.id);
    }

}
