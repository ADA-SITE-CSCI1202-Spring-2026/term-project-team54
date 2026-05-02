package com.team54.airportdispatchtycoonteam54.core.Events;


import java.util.Random;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.Queue;


public class FlightTimelineManager implements TickableInterface {
    

    


    Double chancePerTickToSpawn;

    FlightRequest flightRequest;
    Random random;




    FlightTimelineManager(double chancePerTickToSpawn) {
        random = new Random();
        setSpawnChance(chancePerTickToSpawn);
        
        // flightRequest = new FlightRequest();
    }


    public void setSpawnChance(Double p){
        this.chancePerTickToSpawn = Math.clamp(p,0d,1d);
    }


    @Override
    public void onTick(){
        Double p = random.nextDouble();
        if(!(chancePerTickToSpawn<p))return;
        
        flightRequest = new FlightRequest();
        Queue.addAircraft(flightRequest.getAircraft());

    }
}
