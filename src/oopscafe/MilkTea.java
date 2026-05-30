/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe;


/**
 *
 * @author Acer
 */
public class MilkTea extends Drink {
    public MilkTea (String drinkName, double price, String size, int quantity) {
        super (drinkName, "Milk Tea", price, size, quantity);
        setPrice (calculatePrice());
    }
    
    @Override
    public double calculatePrice() {
        String drink = getDrinkName();
        String size = getSize();
        
        switch (drink) {
            case "Matcha Milk Tea":
                if (size.equals("ENCAP")) return 120;
                else if (size.equals("INHE")) return 140;
                else if (size.equals("POLY")) return 160;
                break;
            case "Chocolate Milk Tea":
                if (size.equals("ENCAP")) return 125;
                else if (size.equals("INHE")) return 145;
                else if (size.equals("POLY")) return 165;
                break;
            case "Taro Milk Tea":
                if (size.equals("ENCAP")) return 130;
                else if (size.equals("INHE")) return 150;
                else if (size.equals("POLY")) return 170;
                break;
            case "Brown Sugar Milk Tea":
                if (size.equals("ENCAP")) return 135;
                else if (size.equals("INHE")) return 155;
                else if (size.equals("POLY")) return 175;
                break;
            case "Strawberry Milk Tea":
                if (size.equals("ENCAP")) return 140;
                else if (size.equals("INHE")) return 160;
                else if (size.equals("POLY")) return 180;
                break;
        }
        return 0;
    }
    @Override
    public double calculateTotal() {
        return calculatePrice() * getQuantity();
    }
}
