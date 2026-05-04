package com.team54.airportdispatchtycoonteam54.core.Resource;

public enum SupplyItem {
    FUEL("Fuel"),
    MEAL("Meal"),
    LUGGAGE("Luggage Cart");

    private final String label;

    SupplyItem(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return label;
    }
}
