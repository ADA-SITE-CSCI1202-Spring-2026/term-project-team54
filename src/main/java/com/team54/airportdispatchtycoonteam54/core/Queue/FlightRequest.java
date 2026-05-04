package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.util.Random;
import com.team54.airportdispatchtycoonteam54.core.Planes.*;

public class FlightRequest {
    Aircraft aircraft;

    public FlightRequest(){
        aircraft = AircraftFactory.create(type,needs);
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

}
