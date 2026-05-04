package com.team54.airportdispatchtycoonteam54.core.Planes;

import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public abstract class Aircraft {

    //TODO: make it work across sessions
    private static Integer id = 0;

    private Integer flightNumber;
    private Float turnAroundTime;

    private AircraftNeeds needs;

    public Aircraft(AircraftNeeds needs){
        // this.turnAroundTime = turnAroundTime;
        id++;
        this.flightNumber = id;

        //TODO: SET THIS RANDOMLY HERE
        this.needs = needs;
    }   

    public Integer getFlightNumber() {
        return flightNumber;
    }


    public Integer getSupplyAmountNeeded(SupplyItem item){
        return needs.getRequiredSupplyAmount(item);
    }


    public Float getTurnAroundTime() {
        return turnAroundTime;
    }

    
}
