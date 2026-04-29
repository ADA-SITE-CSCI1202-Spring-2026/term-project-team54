package com.team54.airportdispatchtycoonteam54.core.Queue;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;

public class FlightRequest {


    Aircraft aircraft;

    public FlightRequest(){
        aircraft = FlightGenerator.generateRandom();
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
    
}
