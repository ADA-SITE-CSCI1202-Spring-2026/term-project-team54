package com.team54.airportdispatchtycoonteam54.core.Planes;

public class PrivateCharter extends Aircraft {
    
    public PrivateCharter(){
        super(new AircraftNeeds(
                generateRandomSupplyItemNeed(10, 20), // fuel
                0, // meals
                0 // luggage
        ));
    }

    @Override
    public String toString() {
        return "Private Charter #" + getFlightNumber();
    }

}
