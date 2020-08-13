/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SE140355
 */
public class Student {
    private String studentName;
    private String className;
    private double mathMark;
    private double physicMark;
    private double chemistryMark;
    private double average;
    private String type;

    public Student(String studentName, String className, double mathMark, double physicMark, double chemistryMark) {
        this.studentName = studentName;
        this.className = className;
        this.mathMark = mathMark;
        this.physicMark = physicMark;
        this.chemistryMark = chemistryMark;
        
        this.average = (this.mathMark + this.physicMark + this.chemistryMark) / 3;
        
        if(this.average > 7.5)
            this.type = "A";
        if(this.average <= 7.5 && this.average >=6)
            this.type = "B";
        if(this.average < 6 && this.average >= 4)
            this.type = "C";
        if(this.average < 4)
            this.type = "D";
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicMark() {
        return physicMark;
    }

    public void setPhysicMark(double physicMark) {
        this.physicMark = physicMark;
    }

    public double getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(double chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void showInfo(int i) {
        System.out.println("------ Student " + (i + 1) + " Info ------");
        System.out.println("Name: " + studentName);
        System.out.println("Class: " + className);
        System.out.println("AVG: " + average);
        System.out.println("Type: " + type);
    }

    @Override
    public String toString() {
        return "Student{" + "studentName=" + studentName + ", className=" + className + ", mathMark=" + mathMark + ", physicMark=" + physicMark + ", chemistryMark=" + chemistryMark + '}';
    }
    
    
}
