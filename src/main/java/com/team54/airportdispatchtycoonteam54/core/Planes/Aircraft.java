package com.team54.airportdispatchtycoonteam54.core.Planes;

import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

import java.io.Serializable;

public abstract class Aircraft implements Serializable {

    /**
     * Used to set a flightNumber for each Aircraft.
     */
    private static Integer id = 0;

    private final Integer flightNumber;

    private final AircraftNeeds needs;

    public Aircraft(AircraftNeeds needs){
        id++;
        this.flightNumber = id;

        this.needs = needs;
    }

    public static Integer getID(){
        return id;
    }

    /**
     * Used when loading an existing save file.
     */
    public static void setID(Integer value){
        id = value;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }


    public Integer getSupplyAmountNeeded(SupplyItem item){
        return needs.getRequiredSupplyAmount(item);
    }

    static int generateRandomSupplyItemNeed(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    
}
