/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Acer
 */
public class Receipt {
   /**
 *
 * @author Nyarsh
 */

    
    private static int receiptCounter = 1;
    
    private int receiptNumber;
    private String date;
    private String time;
    private Order order;
    
    // Constructor
    public Receipt(Order order) {
        this.order = order;
        this.receiptNumber = receiptCounter++;
        LocalDateTime now = LocalDateTime.now();
        this.date = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.time = now.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }
    
    // Generate receipt text
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("========================================\n");
        receipt.append("             OOP'S CAFE                 \n");
        receipt.append("========================================\n");
        receipt.append(String.format("Receipt No : %04d\n", receiptNumber));
        receipt.append(String.format("Date       : %s\n", date));
        receipt.append(String.format("Time       : %s\n", time));
        receipt.append("----------------------------------------\n");
        receipt.append(String.format("%-20s %-6s %4s %10s\n",
            "ITEM", "SIZE", "QTY", "TOTAL"));
        receipt.append("----------------------------------------\n");

        for (Drink d : order.getOrderList()) {
            receipt.append(String.format("%-20s %-6s %4d %10s\n",
                d.getDrinkName(),
                d.getSize(),
                d.getQuantity(),
                String.format("₱%.2f", d.calculateTotal())));
        }

        receipt.append("----------------------------------------\n");
        receipt.append(String.format("Total Items : %d\n",
            order.getOrderList().size()));
        receipt.append(String.format("Grand Total : ₱%.2f\n",
            order.computeTotal()));
        receipt.append("========================================\n");
        receipt.append("  Thank You For Visiting OOP'S CAFE!   \n");
        receipt.append("========================================\n");
        
        return receipt.toString();
    }
    
    // Getters
    public int getReceiptNumber() {
        return receiptNumber;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public Order getOrder() {
        return order;
    }
}
