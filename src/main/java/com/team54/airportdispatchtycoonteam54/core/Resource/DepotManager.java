package com.team54.airportdispatchtycoonteam54.core.Resource;


import java.util.HashMap;

public class DepotManager {

    private static DepotManager INSTANCE;

    private static final int INITIAL_BUDGET = 1000;
    private static final int INITIAL_FUEL = 10;
    private static final int INITIAL_MEALS = 10;
    private static final int INITIAL_LUGGAGE = 10;

    private final HashMap<SupplyItem, Integer> supplies;
    private int budget;

    private DepotManager() {
        supplies = new HashMap<>();
        supplies.put(SupplyItem.FUEL, INITIAL_FUEL);
        supplies.put(SupplyItem.MEAL, INITIAL_MEALS);
        supplies.put(SupplyItem.LUGGAGE, INITIAL_LUGGAGE);

        budget = INITIAL_BUDGET;
    }

    public static DepotManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DepotManager();
        }
        return INSTANCE;
    }

    public void loadSaveState(Integer fuel, Integer meals, Integer luggage, Integer budget){
        supplies.put(SupplyItem.FUEL, fuel);
        supplies.put(SupplyItem.MEAL, meals);
        supplies.put(SupplyItem.LUGGAGE, luggage);
        this.budget = budget;
    }
    public Integer getBudget(){
        return budget;
    }

    public void addBudget(int amount){
        budget += amount;
    }

    public Integer getSupplyItemAmount(SupplyItem item){
        return supplies.getOrDefault(item, 0);
    }

    /**
     * Removes a specified amount of a given supply item from the Depo, but
     * only if the Depo has enough of that supply item.
     * @param item The supply item you want to use
     * @param amount The amount of the supply item you want to use.
     * @return True if the DepotManager has enough of the given supply item; false if not.
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

    /**
     * Returns the message to be displayed in the Dispatch Radio after purchase attempt
     */
    public String purchase(SupplyItem item, int amount) {
        double total = amount * item.getPrice();
        if (budget >= total) {
            budget -= total;
            addSupply(item, amount);
            return "Successfully purchased " + amount + " of " + item + ".\n";
        }
        return "ERROR: Not enough money to purchase " + item + "!\n";
    }

    private void addSupply(SupplyItem item, int amount) {
        supplies.put(item, supplies.getOrDefault(item, 0) + amount);
    }
}
