package com.team54.airportdispatchtycoonteam54.core.Planes;

public abstract class Aircraft {
    Integer flightNumber;
    Float requiredFuel;
    Float turnAroundTime;
    Integer requiredMeals;

    Aircraft(Integer flightNumber, Float requiredFuel, Integer meals){
        // this.turnAroundTime = turnAroundTime;
        this.requiredFuel = requiredFuel;
        this.flightNumber = flightNumber;
        this.requiredMeals = meals;
    }   



    public Integer getFlightNumber() {
        return flightNumber;
    }

    public Float getRequiredFuel() {
        return requiredFuel;
    }

    public Float getTurnAroundTime() {
        return turnAroundTime;
    }

    public Integer getMeals() {
        return requiredMeals;
    }

    public void supplyMeals(Integer meals) {
        this.requiredMeals += meals;
    }

    public void supplyFuel(Float fuel) {
        this.requiredFuel += fuel;
    }
    
    
    
}
