package com.team54.airportdispatchtycoonteam54.core.Resource;

public enum SupplyItem {
    FUEL("Fuel", 10),
    MEAL("Meal", 10),
    LUGGAGE("Luggage Cart", 10);

    private final String label;
    private final int price;

    SupplyItem(String label, int price) {
        this.label = label;
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return label;
    }
}
