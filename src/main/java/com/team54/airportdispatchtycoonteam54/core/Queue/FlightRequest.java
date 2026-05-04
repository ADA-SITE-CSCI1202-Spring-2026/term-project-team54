package com.team54.airportdispatchtycoonteam54.core.Queue;

import com.team54.airportdispatchtycoonteam54.core.Planes.*;

public class FlightRequest {
    private final Aircraft aircraft;

    /**
     * How much money you get if you service and clear
     * this flight request successfully.
     */
    private final int successfulServiceRevenue;

    public FlightRequest(AircraftType type){
        aircraft = AircraftFactory.create(type);
        successfulServiceRevenue = 300;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public int getSuccessfulServiceRevenue() {
        return successfulServiceRevenue;
    }

    @Override
    public String toString() {
        return aircraft.toString();
    }
}
