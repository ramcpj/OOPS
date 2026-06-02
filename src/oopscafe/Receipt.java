/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopscafe;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;   // ← ADD THIS IMPORT
import java.util.Map;
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
    
    private LinkedHashMap<String, int[]> aggregateItems() {
        LinkedHashMap<String, int[]> map = new LinkedHashMap<>();
        for (Drink d : order.getOrderList()) {
            String key = d.getDrinkName() + "|" + d.getSize();
            if (map.containsKey(key)) {
                map.get(key)[0] += d.getQuantity();   // accumulate qty
            } else {
                // store: [qty, unitPrice]
                // unitPrice = calculateTotal() / qty  (handles qty>1 drinks too)
                int unitPrice = (int)(d.calculateTotal() / d.getQuantity());
                map.put(key, new int[]{ d.getQuantity(), unitPrice });
            }
        }
        return map;
    }
    
    // Generate receipt text
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("==================================================\n");
        receipt.append("                    OOP'S CAFE                    \n");
        receipt.append("==================================================\n");
        receipt.append(String.format("Receipt No : %04d\n", receiptNumber));
        receipt.append(String.format("Date       : %s\n", date));
        receipt.append(String.format("Time       : %s\n", time));
        receipt.append("--------------------------------------------------\n");
         receipt.append(String.format("%-20s %-6s %4s %6s %10s\n",
            "ITEM", "SIZE", "QTY", "PRICE", "SUBTOTAL"));
        receipt.append("--------------------------------------------------\n");

         LinkedHashMap<String, int[]> aggregated = aggregateItems();
        int totalQtySum = 0;

        for (Map.Entry<String, int[]> entry : aggregated.entrySet()) {
            String key       = entry.getKey();
            int    qty       = entry.getValue()[0];
            int    unitPrice = entry.getValue()[1];
            int    subtotal  = qty * unitPrice;

            // Split key back into name and size
            String[] parts = key.split("\\|", 2);
            String   name  = parts[0];
            String   size  = parts[1];

            receipt.append(String.format("%-20s %-6s %4d %6s %10s\n",
                name,
                size,
                qty,
                String.format("₱%d", unitPrice),
                String.format("₱%.2f", (double) subtotal)));

            totalQtySum += qty;
        }

        receipt.append("--------------------------------------------------\n");
        receipt.append(String.format("Total Items : %d\n", totalQtySum));
        receipt.append(String.format("Grand Total : ₱%.2f\n",
            order.computeTotal()));
        receipt.append("==================================================\n");
        receipt.append("        Thank You For Visiting OOP'S CAFE!        \n");
        receipt.append("==================================================\n");
        
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
