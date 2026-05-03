package com.team54.airportdispatchtycoonteam54.core.Planes;

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

    public Float getRequiredFuel() {
        return needs.requiredFuel;
    }

    public Float getTurnAroundTime() {
        return turnAroundTime;
    }

    public Integer getMeals() {
        return needs.requiredMeals;
    }

    public void supplyMeals(Integer meals) {
        needs.requiredMeals += meals;
    }

    public void supplyFuel(Float fuel) {
        needs.requiredFuel += fuel;
    }

    
}
