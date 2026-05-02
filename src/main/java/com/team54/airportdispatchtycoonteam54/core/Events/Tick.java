package com.team54.airportdispatchtycoonteam54.core.Events;

import java.util.Random;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Tick {
    
    Integer ticksPerSecond;
    Timeline loopingTimeline;
    Random random = new Random();
    FlightRequest flightRequest;



    // When created, begins the Tick process. Please only create a single instance of the Tick class :)
    Tick(Integer tps){
        // ticksPerSecond = tps;
        changeTicksPerSecond(tps);
    }

    void startLoop(){
        loopingTimeline.stop(); 
        flightRequest = new FlightRequest();
        // Create a timeline with 1/tps, so that each second there are tps amount of tick calls.
        loopingTimeline.getKeyFrames().setAll(
            new KeyFrame(Duration.seconds(1d/ticksPerSecond), e -> {
                TickableInterface.callTick();
                startLoop(); 
            })
        );
        loopingTimeline.play();
    }


    void changeTicksPerSecond(Integer tps){
        loopingTimeline.stop();
        ticksPerSecond = tps;
        startLoop();
    }

}
