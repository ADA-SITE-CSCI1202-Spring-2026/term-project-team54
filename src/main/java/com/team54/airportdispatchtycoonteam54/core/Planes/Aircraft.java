package com.team54.airportdispatchtycoonteam54.core.Planes;

public abstract class Aircraft {
    Integer flightNumber;
    Float requiredFuel;
    Float turnAroundTime;

    Aircraft(Integer flightNumber, Float requiredFuel, Float turnAroundTime){
        this.turnAroundTime = turnAroundTime;
        this.requiredFuel = requiredFuel;
        this.flightNumber = flightNumber;
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
    
    
}
