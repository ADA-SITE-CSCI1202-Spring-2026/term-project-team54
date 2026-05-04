package com.team54.airportdispatchtycoonteam54.core.Resource;


import java.util.HashMap;

public class DepotManager {

    private static DepotManager INSTANCE;
    private static final double INITIAL_BUDGET = 100;

    private final HashMap<SupplyItem, Integer> supplies;
    private double budget;

    private DepotManager() {
        supplies = new HashMap<>();
        budget = INITIAL_BUDGET; //TODO: read from config
    }

    public static DepotManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DepotManager();
        }
        return INSTANCE;
    }

    /**
     * Removes a specified amount of a given supply item from the Depo, but
     * only if the Depo has enough of that supply item.
     * @param item The supply item you want to use
     * @param amount The amount of the supply item you want to use.
     * @return True if the DepotManager has enough of the given supply; false if not.
     */
    public boolean useSupply(SupplyItem item, int amount) {
        if (hasEnough(item, amount)) {
            addSupply(item, -1 * amount);
            return true;
        }
        return false;
    }

    public boolean hasEnough(SupplyItem item, int amount) {
        return supplies.getOrDefault(item, 0) >= amount;
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

    private void addSupply(SupplyItem item, int amount) {
        supplies.put(item, supplies.getOrDefault(item, 0) + amount);
    }
}
