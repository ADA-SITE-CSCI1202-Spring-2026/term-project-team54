package com.team54.airportdispatchtycoonteam54.core.Events;


import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequestQueue;


public class RandomFlightRequestGenerator implements ITickable {

    private static RandomFlightRequestGenerator INSTANCE;
    private final FlightRequestQueue flightRequestQueue;

    private RandomFlightRequestGenerator(FlightRequestQueue flightRequestQueue) {
        this.flightRequestQueue = flightRequestQueue;
        INSTANCE = this;
    }

    public static RandomFlightRequestGenerator getInstance() throws IllegalStateException{
        if(INSTANCE == null){
            throw new IllegalStateException("Cannot get instance of RandomFlightRequestGenerator before it is created. " +
                    "Please use createInstance(FlightRequestQueue) to create an instance first.");
        }
        return INSTANCE;
    }

    public static RandomFlightRequestGenerator  createInstance(FlightRequestQueue flightRequestQueue) {
        if (INSTANCE == null) {
            INSTANCE = new RandomFlightRequestGenerator(flightRequestQueue);
            INSTANCE.subscribe();
        }
        return INSTANCE;
    }

    @Override
    public void onTick(){
        flightRequestQueue.addFlightRequest(new FlightRequest());
    }
}
