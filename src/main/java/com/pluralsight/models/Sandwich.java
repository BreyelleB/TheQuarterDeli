package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType bread;
    private boolean toasted;
    private List<Topping> meats = new ArrayList<>();
    private List <Topping> cheeses = new ArrayList<>();
    private List <Topping> regularToppings = new ArrayList<>();
    private List < Topping> sauces = new ArrayList<>();


    public Sandwich (SandwichSize size, BreadType bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;

    }
        public void addMeat(String name, boolean extra) {
        meats.add(new PremiumTopping(name, size, extra, true));

        }

        public void addCheese(String name, boolean extra) {
            cheeses.add(new PremiumTopping(name, size, extra, false ));

        }

        public void addTopping(String name) {
            regularToppings.add(new RegularTopping(name));
        }

        public void addSauce(String name) {
            sauces.add(new RegularTopping(name));

        }

        public double getPrice() {
            double base = switch (size) {
                case FOUR -> 5.50;
                case EIGHT -> 7.00;
                case TWELVE -> 8.50;
            };

            double toppings = 0;
            for(Topping t : meats) toppings += t.getPrice();
            for (Topping t : cheeses) toppings += t.getPrice();
            return base + toppings;
        }

        public String getSummary() {
            return String.format (""" 
        Size: %s
        Bread: %s
        Toasted:%s
        Meats: %s
        Cheeses:%s
        Toppings:%s
        Sauces:%s
        Price:%s
        """, size, bread, toasted ? "Yes please" : "No Thank you", meats, cheeses, regularToppings, sauces, getPrice());
        }

    }


