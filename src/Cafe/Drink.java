/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe; 

/**
 *
 * @author Acer
 */
public class Drink {
    private String drinkName;
    private double price;
    private String size;
    
    //Constructors 
    public Drink (String drinkName, double price, String size) {
        this.drinkName = drinkName;
        this.price = price;
        this.size = size;
    }
    
    // getters
    public String getDrinkName() {
     return drinkName;
    }
    public double getPrice() {
        return price;
    }
    public String getSize() {
        return size;
    }
    
    //setters
    public void setDrinkName (String drink) {
        this.drinkName = drink;
    }
    public void setPrice (double price) {
        this.price = price;
    }
    public void setSize (String size) {
        this.size = size;
    }
}

