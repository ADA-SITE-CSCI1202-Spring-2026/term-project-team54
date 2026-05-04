package com.team54.airportdispatchtycoonteam54.core.Events;


import com.team54.airportdispatchtycoonteam54.core.Planes.AircraftType;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequestQueue;

import java.util.Random;


public class RandomFlightRequestGenerator implements ITickable {

    private static final Random RNG = new Random();

    private static RandomFlightRequestGenerator INSTANCE;
    private final FlightRequestQueue flightRequestQueue;

    private RandomFlightRequestGenerator(FlightRequestQueue flightRequestQueue) {
        this.flightRequestQueue = flightRequestQueue;
    }

    public static RandomFlightRequestGenerator getInstance() throws IllegalStateException{
        if(INSTANCE == null){
            throw new IllegalStateException("Cannot get instance of RandomFlightRequestGenerator before it is created. " +
                    "Please use initialize(FlightRequestQueue) to create an instance first.");
        }
        return INSTANCE;
    }

    public static RandomFlightRequestGenerator initialize(FlightRequestQueue flightRequestQueue) {
        if (INSTANCE == null) {
            INSTANCE = new RandomFlightRequestGenerator(flightRequestQueue);
            INSTANCE.subscribe();
        }
        return INSTANCE;
    }

    @Override
    public void onTick(){
        AircraftType[] types = AircraftType.values();
        AircraftType randomType = types[RNG.nextInt(types.length)];
        flightRequestQueue.add(new FlightRequest(randomType));
    }
}
