package com.pluralsight.models;

public class RegularTopping implements Topping {
    private String name;

    public RegularTopping (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public String toString() {
        return name;
    }
}
