/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe; 

/**
 *
 * @author Acer
 */
public class Drink {
    private String drinkName;
    private String type;
    private double price;
    private String size;
    private int quantity;
    
    //Constructors 
    public Drink (String drinkName, String type, double price, String size, int quantity) {
        this.drinkName = drinkName;
        this.type = type;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
    }
    
    // getters
    public String getDrinkName() {
     return drinkName;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public String getSize() {
        return size;
    }
    public int getQuantity() {
        return quantity;
    }
    
    //setters
    public void setDrinkName (String drink) {
        this.drinkName = drink;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPrice (double price) {
        this.price = price;
    }
    public void setSize (String size) {
        this.size = size;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    //Method
    public double calculatePrice() {
        return price;
    }
    public double calculateTotal() {
        return price * quantity;
    }
}

