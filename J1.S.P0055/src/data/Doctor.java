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
public class Doctor implements Comparable<Doctor>{
    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor(String code, String name, String Specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = Specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    public void showProfile() {
        String msg;
        msg = String.format("|%6s|%-15s|%8s|%3d|", code, name, specialization, availability);
        System.out.println(msg);
}

    @Override
    public int compareTo(Doctor o) {
        return this.code.compareToIgnoreCase(o.code);
    }
}