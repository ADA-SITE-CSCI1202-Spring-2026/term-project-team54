package com.team54.airportdispatchtycoonteam54.core.Planes;

import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public abstract class Aircraft {
    Integer flightNumber;
    Float turnAroundTime;
    
    // Float requiredFuel;
    // Integer requiredMeals;
    // Integer requiredLuggage;

    AircraftNeeds needs;

    Aircraft(Integer flightNumber, AircraftNeeds needs){
        // this.turnAroundTime = turnAroundTime;
        this.flightNumber = flightNumber;

        this.needs = needs;
    }   



    public Integer getFlightNumber() {
        return flightNumber;
    }


    public Integer getSupplyAmountNeeded(SupplyItem item){
        return needs.requiredSupplies.get(item);
    }

    



    // public Integer getRequiredFuel() {
    //     return needs.requiredFuel;
    // }

    public Float getTurnAroundTime() {
        return turnAroundTime;
    }

    // public Integer getMeals() {
    //     return needs.requiredMeals;
    // }

    // public void supplyMeals(Integer meals) {
    //     needs.requiredMeals += meals;
    // }

    // public void supplyFuel(Integer fuel) {
    //     needs.requiredFuel += fuel;
    // }


    

    
}
