package com.team54.airportdispatchtycoonteam54.core.SaveLoad;

import java.io.Serializable;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequestQueue;

public class SaveData implements Serializable {
    private final Integer currentFuel;
    private final Integer currentMeal;
    private final Integer currentLuggage;
    private final Integer currentBudget;
    private final Integer currentAircraftID;
    private final FlightRequestQueue currentQueuedFlightRequests;


    public SaveData(Integer currentFuel, Integer currentMeal, Integer currentLuggage, Integer currentBudget,
            Integer currentAircraftID, FlightRequestQueue currentQueuedFlightRequests) {
        this.currentFuel = currentFuel;
        this.currentMeal = currentMeal;
        this.currentLuggage = currentLuggage;
        this.currentBudget = currentBudget;
        this.currentAircraftID = currentAircraftID;
        this.currentQueuedFlightRequests = currentQueuedFlightRequests;
    }


    public Integer getCurrentFuel() {
        return currentFuel;
    }


    public Integer getCurrentMeal() {
        return currentMeal;
    }


    public Integer getCurrentLuggage() {
        return currentLuggage;
    }


    public Integer getCurrentBudget() {
        return currentBudget;
    }


    public Integer getCurrentAircraftID() {
        return currentAircraftID;
    }


    public FlightRequestQueue getCurrentQueuedFlightRequests() {
        return currentQueuedFlightRequests;
    }
    
}
