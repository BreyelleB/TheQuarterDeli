package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        String fileName = "receipts/" + generateTimestamp() + ". txt";
        try {
            File dir = new File("receipts");
            if (!dir.exists()) dir.mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(order.getOrderSummary());
            writer.close();
            System.out.println("Receipt has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }

    private static String generateTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    }
}

