package com.team54.airportdispatchtycoonteam54.core.SaveLoad;

import java.io.Serializable;
import java.util.ArrayList;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequestQueue;

import javafx.collections.ObservableList;

public class SaveData implements Serializable {
    private Integer currentFuel;
    private Integer currentMeal;
    private Integer currentLuggage;
    private Double currentMoney;
    private Integer currentAircraftID;
    private FlightRequestQueue currentQueuedFlightRequests;


    public SaveData(Integer currentFuel, Integer currentMeal, Integer currentLuggage, Double currentMoney,
            Integer currentAircraftID, FlightRequestQueue currentQueuedFlightRequests) {
        this.currentFuel = currentFuel;
        this.currentMeal = currentMeal;
        this.currentLuggage = currentLuggage;
        this.currentMoney = currentMoney;
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


    public Double getCurrentMoney() {
        return currentMoney;
    }


    public Integer getCurrentAircraftID() {
        return currentAircraftID;
    }


    public FlightRequestQueue getCurrentQueuedFlightRequests() {
        return currentQueuedFlightRequests;
    }


        
    
}
