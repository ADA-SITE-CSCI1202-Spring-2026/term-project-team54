package com.team54.airportdispatchtycoonteam54.core.Events;

import java.util.Random;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Queue.Queue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class FlightTimelineManager {
    

    
    // JavaFX timeline-spawning the flights is
    // basically just an animation with a random length with a keyframe that calls a spawn function
    Timeline loopingTimeline;

    Double minNextFlightTime;
    Double maxNextFlightTime;

    Random random;
    FlightRequest flightRequest;




    FlightTimelineManager(double minNext, double maxNext) {
        this.minNextFlightTime = minNext;
        this.maxNextFlightTime = maxNext;


        loopingTimeline = new Timeline();
        flightRequest = new FlightRequest();
        random = new Random();


        startLoop();
    }



    void startLoop() {
        loopingTimeline.stop(); 

        // Create a timeline with random delay
        double delay = random.nextDouble(minNextFlightTime, maxNextFlightTime);
        loopingTimeline.getKeyFrames().setAll(
            new KeyFrame(Duration.seconds(delay), e -> {
                Queue.addAircraft(flightRequest.getAircraft());
                startLoop(); 
            })
        );
        loopingTimeline.play();
    }

}
