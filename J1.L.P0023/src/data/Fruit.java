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
public class Fruit implements Comparable<Fruit>{
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String origin;
    
    public Fruit(Fruit fruitToCopy) {
        this.id = fruitToCopy.id;
        this.name = fruitToCopy.name;
        this.origin = fruitToCopy.origin;
        this.price = fruitToCopy.price;
        this.quantity = fruitToCopy.quantity;
    }

    public Fruit(String id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public void updateStockQuantity(int bought) {
        quantity -= bought;
    }

    @Override
    public String toString() {
        return "Fruit{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", origin=" + origin + '}';
    }
    
    public void showFullDetail() {
        System.out.printf("%3s | %-10s | %-10s | %5.1f$ | %10d\n", id, name, origin, price, quantity);
    }
    
    public void showGroceries(int i) {
        System.out.printf("%5s | %-10s | %-10s | %5.1f$ | %10d\n", i, name, origin, price, quantity);
    }
    
    protected void printOrderedProduct() {
        System.out.printf("%10s | %10d | %7.1f$ | %8.1f$\n", name, quantity, price, quantity * price);
    }

    @Override
    public int compareTo(Fruit o) {
        return this.id.compareToIgnoreCase(o.id);
    }
}
