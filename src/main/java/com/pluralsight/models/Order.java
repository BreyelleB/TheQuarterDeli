package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList();

    public void addSandwich (Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(Drink d) {
        drinks.add(d);
    }

    public void addChips(Chips c) {
        chips.add(c);
    }

    public double getTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        for (Sandwich s : sandwiches) sb.append(s.getSummary()).append("\n");
        for (Drink d : drinks) sb.append("Drink flavor: ").append(d).append("\n");
        for (Chips c : chips) sb.append("Chip flavor ").append(c).append("\n");
        return sb.toString();

    }
}
