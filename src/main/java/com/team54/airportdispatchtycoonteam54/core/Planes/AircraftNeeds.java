package com.team54.airportdispatchtycoonteam54.core.Planes;

import java.util.HashMap;

import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

/**
 * Stores the required resources for a particular Aircraft
 */
public class AircraftNeeds{

    private final HashMap<SupplyItem,Integer> requiredSupplies;

    public AircraftNeeds(Integer fuel, Integer meals, Integer luggage){
        requiredSupplies = new HashMap<>();
        requiredSupplies.put(SupplyItem.FUEL, fuel);
        requiredSupplies.put(SupplyItem.MEAL, meals);
        requiredSupplies.put(SupplyItem.LUGGAGE, luggage);
    }

    public Integer getRequiredSupplyAmount(SupplyItem supplyItem){
        return requiredSupplies.get(supplyItem);
    }
}