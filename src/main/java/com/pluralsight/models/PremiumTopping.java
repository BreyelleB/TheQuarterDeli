package com.pluralsight.models;

import javax.print.attribute.standard.MediaSize;

public class PremiumTopping implements Topping {
    private String name;
    private SandwichSize size;
    private boolean extra;
    private boolean isMeat;

    public PremiumTopping(String name, SandwichSize size, boolean extra, boolean isMeat) {
        this.name = name;
        this.size = size;
        this.extra = extra;
        this.isMeat = isMeat;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean isExtra() {
        return extra;
    }

    @Override
    public double getPrice() {
        double basePrice = switch (size) {
            case FOUR -> isMeat ? 1.00 : 0.75;
            case EIGHT -> isMeat ? 2.00 : 1.50;
            case TWELVE -> isMeat ? 3.00 : 2.25;

        };
        if (extra) {
            basePrice += switch (size) {
                case FOUR -> isMeat ? 0.50 : 0.30;
                case EIGHT -> isMeat ? 1.00 : 0.60;
                case TWELVE -> isMeat ? 1.50 : 0.90;
            };
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return name + (extra ? "(Extra)" : "");

    }
}
