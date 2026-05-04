package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.util.Random;
import com.team54.airportdispatchtycoonteam54.core.Planes.*;

public class FlightRequest {
    Aircraft aircraft;

    public FlightRequest(AircraftType type){
        aircraft = AircraftFactory.create(type);
    }

    public Aircraft getAircraft() {
        return aircraft;
    }


    @Override
    public String toString() {
        return "IMPLEMENT TO STRING"; // TODO:
    }
}
