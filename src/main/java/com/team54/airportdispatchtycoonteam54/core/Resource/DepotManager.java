package com.team54.airportdispatchtycoonteam54.core.Resource;


import java.util.HashMap;

public class DepotManager {

    private HashMap<SupplyItem, Integer> supplies;
    private double budget;

    public DepotManager(double initialBudget) {
        supplies = new HashMap<>();
        budget = initialBudget;
    }

    public void addSupply(SupplyItem item, int amount) {
        supplies.put(item, supplies.getOrDefault(item, 0) + amount);
    }


    public boolean hasEnough(SupplyItem item, int amount) {
        return supplies.getOrDefault(item, 0) >= amount;
    }

    public Integer useSupply(SupplyItem item, int amount) {
        Integer usedSupplyAmount;
        
        if (hasEnough(item, amount)) {
            usedSupplyAmount = amount;
            supplies.put(item, supplies.get(item) - amount);
            return usedSupplyAmount;
        }
        usedSupplyAmount = supplies.get(item);
        supplies.put(item, 0);
        return usedSupplyAmount;

    }

    
    public boolean purchase(SupplyItem item, int amount, double price) {
        double total = amount * price;
        if (budget >= total) {
            budget -= total;
            addSupply(item, amount);
            return true;
        }
        return false;
    }
}
