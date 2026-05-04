package com.team54.airportdispatchtycoonteam54.core.Services;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Resource.DepotManager;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public class FuelingTruck implements IGroundService{

    private final SupplyItem requiredSupplyItem = SupplyItem.FUEL;

    @Override
    public String toString() {
        return "Fueling Truck";
    }

    @Override
    public void serviceFlight(FlightRequest flightRequest) {
        DepotManager.getInstance().
                useSupply(
                        requiredSupplyItem,
                        flightRequest.getAircraft().getSupplyAmountNeeded(requiredSupplyItem)
                );

    }

    @Override
    public Boolean canServiceFlight(Integer amount) {
        return DepotManager.getInstance().hasEnough(requiredSupplyItem, amount);
    }

    @Override
    public SupplyItem getRequiredSupplyItem() {
        return requiredSupplyItem;
    }
}

