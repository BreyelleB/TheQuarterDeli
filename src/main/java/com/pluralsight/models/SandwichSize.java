package com.pluralsight.models;

public enum SandwichSize {
    FOUR(5.50),
    EIGHT(7.00),
    TWELVE(8.50);

    private final double basePrice;

    SandwichSize(double basePrice) {
        this.basePrice = basePrice;

    }

    public double getBasePrice() {
        return basePrice;
    }


    @Override
    public String toString() {
        return switch (this) {
        case FOUR -> "4 inch";
        case EIGHT -> "8 inch";
        case TWELVE -> "12 inch";
    };

}
}
