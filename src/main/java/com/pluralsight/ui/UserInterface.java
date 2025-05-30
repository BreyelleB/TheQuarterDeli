package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order = new Order();

    public void start() {
        while (true) {
            System.out.println("Hello Welcome to QuarterDeli SandwichShop!");
            System.out.println("1) Start New Order");
            System.out.println("0) Exit Menu");
            String choice = scanner.nextLine();
            if (choice.equals("1")) handleOrder();
            else break;
        }
    }

    private void handleOrder() {
        order = new Order();
        while (true) {
            System.out.println("""
                    Order Menu:
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    """);

            String choice = scanner.nextLine();
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
                    System.out.println("Confirm order? (Yes/No): ");
                    if (scanner.nextLine().equalsIgnoreCase("Yes")) {
                        ReceiptWriter.saveReceipt(order);
                        System.out.println("Order confirmed and receipt saved. ");
                    } else {
                        System.out.println("Order canceled.");
                    }
                    return;
                }
                case "0" -> {
                    System.out.println("Order has been canceled.");
                    return;
                }

                default -> System.out.println("Invalid choice. Please Try again. ");
            }
        }
    }


    //Asking for the sandwich size
    private Sandwich buildSandwich() {
        System.out.println("Size (4, 8, 12): ");
//        Sandwich newSandwich = new Sandwich();
        int inches = Integer.parseInt(scanner.nextLine());
        SandwichSize size = switch (inches) {
            case 4 -> SandwichSize.FOUR;
            case 8 -> SandwichSize.EIGHT;
            case 12 -> SandwichSize.TWELVE;
            default -> SandwichSize.EIGHT;
        };

        //Ask user for bread type
        System.out.println("Select your bread type (WHITE, WHEAT, RYE, WRAP, FRENCH): ");
        BreadType bread = BreadType.valueOf(scanner.nextLine().toUpperCase());

        //Ask user if they want it toasted
        System.out.println("Would you like it toasted? (Yes/No): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Yes");

        Sandwich newSandwich = new Sandwich(size, bread, toasted);

        //Ask user what type of meats they want
        System.out.println("Add meats (type one at a tine, or type 'Done'): ");
        while (true) {
            System.out.println("Select meat: ");
            String meat = scanner.nextLine();
            if (meat.equalsIgnoreCase("Done")) break;

            System.out.println("Would you like extra meat? (Yes/No): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

            newSandwich.addMeat(meat, extra);

        }
        // Ask user what cheeses they would like if any
        System.out.println("Add cheese (type one at a time, or type 'done'):");
        while (true) {
            System.out.print("Cheese: ");
            String cheese = scanner.nextLine();
            if (cheese.equalsIgnoreCase("Done")) break;

            System.out.println("Extra cheese? (Yes please/No Thank you): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("Yes");

            newSandwich.addCheese(cheese, extra);

        }

        //Ask user what toppings they would like
        System.out.println("Add your regular toppings (type one at a time, or type 'Done'): ");
        while (true) {
            System.out.println("Toppings: ");
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("Done")) break;

            newSandwich.addTopping(topping);

        }
        //Ask user what sauces they would like
        System.out.println("Add sauces (type one at a time, or type 'Done'): ");
        while (true) {
            System.out.println("Sauce: ");
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("Done")) break;

            newSandwich.addSauce(sauce);

        }

        //Print out summary of order
        System.out.println("\nSandwich Summary: ");
        System.out.println(newSandwich.getSummary());


        return newSandwich;
    }
}
