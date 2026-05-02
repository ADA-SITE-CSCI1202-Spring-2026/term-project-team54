package com.team54.airportdispatchtycoonteam54.core.Events;

import java.util.ArrayList;
import java.util.Random;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TickSingleton {
    
    Integer ticksPerSecond;

    Timeline loopingTimeline;
    Random random = new Random();
    FlightRequest flightRequest;

    static TickSingleton instance;


    private ArrayList<ITickable> tickables = new ArrayList<>();


    // When created, begins the Tick process. Private to adhere to SIngleton pattern.
    private TickSingleton(Integer ticksPerSecond){
        if(instance!=null)return;
        changeTicksPerSecond(ticksPerSecond);
    }


    // SIngleton code for creating/getting. 
    public static TickSingleton getInstance(){
        return instance;
    }

    public static TickSingleton createInstance(Integer ticksPerSecond){
        if(instance==null){
            instance = new TickSingleton(ticksPerSecond);
            instance.startLoop();
        }
        return instance;
    }




    public static void addITickable(ITickable tickable){
        if(!instance.tickables.contains(tickable)){
            instance.tickables.add(tickable);
        }
    }


    private void tickAllITickables(){
        for (ITickable tickableInterface : instance.tickables) {
            tickableInterface.onTick();
        }
    } 

    

    // to begin the Ticking
    public void startLoop(){
        loopingTimeline.stop(); 
        // Create a timeline with 1/ticksPerSecond, so that each second there are ticksPerSecond amount of tick calls.
        loopingTimeline.getKeyFrames().setAll(
            new KeyFrame(Duration.seconds(1d/ticksPerSecond), e -> {
                tickAllITickables();
                startLoop(); 
            })
        );
        loopingTimeline.play();
    }


    private void changeTicksPerSecond(Integer ticksPerSecond){
        loopingTimeline.stop();
        this.ticksPerSecond = ticksPerSecond;
        startLoop();
    }

}
