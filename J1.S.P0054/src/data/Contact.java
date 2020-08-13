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
public class Contact implements Comparable<Contact>{
    private String id;
    private String fullname;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Contact(String id, String fullname, String firstName, String lastName, String group, String address, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", fullname=" + fullname + ", firstName=" + firstName + ", lastName=" + lastName + ", group=" + group + ", address=" + address + ", phone=" + phone + '}';
    }
    
    public void showContactInfo() {
        System.out.printf("%5s | %-20s | %-12s | %-15s | %-8s | %-8s | %-21s\n", id, fullname, firstName, lastName, group, address, phone);
    }

    @Override
    public int compareTo(Contact o) {
        return this.id.compareToIgnoreCase(o.id);
    }
    
}
