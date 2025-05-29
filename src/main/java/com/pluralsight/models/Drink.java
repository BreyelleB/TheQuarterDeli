package com.pluralsight.models;

public class Drink {
    private DrinkSize size;
    private String flavor;


    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public  double getPrice() {
        return switch (size) {
            case SMALL -> 2.00;
            case MEDUIM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    public String toString() {
        return size + " " + flavor;
    }
}
