package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order = new Order();

    public void start() {
        while (true) {
            System.out.println("Hello Welcome to QuaterDeli SandwichShop!");
            System.out.println("1) Start New Order");
            System.out.println("0) Exit Menu");
            String choice = scanner.nextLine();
            if (choice.equals("1")) handleOrder();
            else break;
        }
    }

    private void handleOrder() {
        while (true) {
            System.out.println("1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel");
            String choice = scanner.nextLine()
            switch (choice) {
                case "1" -> order.addSandwich(buildSandwich());
                case "2" -> {
                    System.out.println("Drink Flavor: ");
                    String flavor = scanner.nextLine();
                    System.out.println("Size (SMALL, MEDIUM, LARGE):");
                    DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
                    order.addDrink(new Drink(size, flavor));

                }

                case "3" -> {
                    System.out.println("Chip Flavor: ");
                    order.addChips(new Chips(scanner.nextLine()));
                }
                case "4" -> {
                    System.out.println(order.getOrderSummary());
                    System.out.println("Confirm order? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) ReceiptWriter.saveReceipt(order);
                    return;
                }
                case "0" -> {
                    System.out.println("Order has been canceled.");
                    return;
                }
            }
        }
    }

    private Sandwich buildSandwich() {
        System.out.println("Size (4, 8, 12): ");
        Sandwich newSandwich = new Sandwich();
        int inches =    Integer.parseInt(scanner.nextLine());
        SandwichSize size = switch (inches) {
            case 4 -> SandwichSize.FOUR;
            case 8 -> SandwichSize.EIGHT;
            case 12 -> SandwichSize.TWELVE;
            default -> SandwichSize.EIGHT;
        };

        return newSandwich;
    }
}