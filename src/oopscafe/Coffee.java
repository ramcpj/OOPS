/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe;

/**
 *
 * @author Acer
 */
public class Coffee extends Drink {
    public Coffee (String drinkName, String type, double price, String size, int quantity) {
        super (drinkName, type, price, size, quantity);
        setPrice(calculatePrice());
    }
    
    @Override
    public double calculatePrice() {
        String drink = getDrinkName();
        String size = getSize();
        String type = getType();
        
        if (type.equals("Hot")) {
            switch (drink) {
                case "Americano":
                    if (size.equals("INHE")) return 95;
                    else if (size.equals("POLY")) return 110;
                    break;
                case "Latte":
                    if (size.equals("INHE")) return 105;
                    else if (size.equals("POLY")) return 120;
                    break;
                case "Espresso":
                    if (size.equals("INHE")) return 100;
                    else if (size.equals("POLY")) return 115;
                    break;
                case "Cappuccino":
                    if (size.equals("INHE")) return 110;
                    else if (size.equals("POLY")) return 125;
                    break;
                case "Caramel MAcchiato":
                    if (size.equals("INHE")) return 125;
                    else if (size.equals("POLY")) return 140;
                    break; 
            }
        }
        else if (type.equals("Cold")) {
            switch (drink) {
                case "Iced Americano":
                    if (size.equals("ENCAP")) return 120;
                    else if (size.equals("INHE")) return 140;
                    else if (size.equals("POLY")) return 160;
                    break;
                case "Iced Latte":
                    if (size.equals("ENCAP")) return 130;
                    else if (size.equals("INHE")) return 150;
                    else if (size.equals("POLY")) return 170;
                    break;
                case "Iced Espresso":
                    if (size.equals("ENCAP")) return 125;
                    else if (size.equals("INHE")) return 145;
                    else if (size.equals("POLY")) return 165;
                    break;
                case "Iced Cappuccino":
                    if (size.equals("ENCAP")) return 135;
                    else if (size.equals("INHE")) return 155;
                    else if (size.equals("POLY")) return 175;
                    break;
                case "Iced Caramel Macchiato":
                    if (size.equals("ENCAP")) return 145;
                    else if (size.equals("INHE")) return 165;
                    else if (size.equals("POLY")) return 185;
                    break;
            }
        }
        return 0;
    }
    @Override
    public double calculateTotal() {
        return calculatePrice() * getQuantity();
    }
}
