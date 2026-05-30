/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Order {
    private ArrayList<Drink> orderList;
    private String customerName;
    private int orderNumber;
    
    //Constructor
    public Order (String customerName, int orderNumber) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.orderList = new ArrayList<>();
    }
    
    //Getters
    public String getCustomerName() {
        return customerName;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public ArrayList<Drink> getOrderList() {
        return orderList;
    }
    
    //Add drink to order
    public void addDrink (Drink drink) {
        orderList.add(drink);
    }
    
    //Remove drink from order
    public void removeDrink (int index) {
        if (index >= 0 && index <orderList.size()) {
            orderList.remove(index);
        } else {
            System.out.println("Invalid order index.");
        }
    }
    
    //Compute total of all drinks
    public double computeTotal() {
        double total = 0;
        for (Drink d : orderList) {
            total += d.calculateTotal();
        }
        return total;
    }
    
    //Display all orders
    public void displayOrders() {
        System.out.println("Customer: "+ customerName);
        System.out.println("Order #: "+ orderNumber);
        System.out.println("-----------------------------");
        for (int i = 0; i < orderList.size(); i++) {
            Drink d = orderList.get(i);
            System.out.println((i+1) + ". " + d.getDrinkName()
                    + "[" + d.getType() + "]" 
                    + "(" + d.getSize() + ")"
                    + "x" + d.getQuantity() 
                    + " - ₱" + d.calculateTotal());     
    }
        System.out.println("-----------------------------");
        System.out.println("Total: ₱" + computeTotal());
}
    
    // Check if order is empty
    public boolean isEmpty() {
        return orderList.isEmpty();
    }
    
    // Clear all orders
    public void clearOrder() {
        orderList.clear();
    }
}