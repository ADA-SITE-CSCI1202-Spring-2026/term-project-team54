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


    public void useSupply(SupplyItem item, int amount) {
        if (hasEnough(item, amount)) {
            supplies.put(item, supplies.get(item) - amount);
        }
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

package resource;

import java.util.HashMap;

public class DepotManager {
    

    private HashMap<SupplyItem, Integer> supplies;
    private double budget;

    public DepotManager(double initialBudget) {
        supplies = new HashMap<>();
        budget = initialBudget;
    }

    public boolean clearFlight(SupplyItem item, int needed) {
        if (supplies.getOrDefault(item, 0) >= needed) {
            supplies.put(item, supplies.get(item) - needed);
            return true;
        }
        return false; 
    }
}
