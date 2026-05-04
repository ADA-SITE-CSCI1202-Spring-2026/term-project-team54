package com.team54.airportdispatchtycoonteam54.core.Events;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TickManager {
    private static TickManager INSTANCE;

    private Timeline loopingTimeline;

    private final ArrayList<ITickable> tickables = new ArrayList<>();


    // Private to adhere to Singleton pattern.
    private TickManager(){}

    // Singleton code for creating/getting.
    // Uses lazy initialization: if INSTANCE is null, creates it and returns it.
    // Otherwise, returns the existing INSTANCE.
    public static TickManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new TickManager();

            INSTANCE.startTicking();

            return INSTANCE;
        }
        return INSTANCE;
    }

    public void pauseTicking() {
        loopingTimeline.pause();
    }

    public void resumeTicking() {
        loopingTimeline.play();
    }

    void addITickable(ITickable tickable){
        if(!tickables.contains(tickable)){
            tickables.add(tickable);
        }
    }

    boolean removeITickable(ITickable tickable){
        return tickables.remove(tickable);
    }

    private void startTicking() {
        float timeBetweenTicks = 3.0f; // TODO: Read from config

        loopingTimeline = new Timeline(
                new KeyFrame(Duration.seconds(timeBetweenTicks), e -> tickAllITickables())
        );

        loopingTimeline.setCycleCount(Animation.INDEFINITE);
        loopingTimeline.play();
    }

    private void tickAllITickables(){
        for (ITickable tickableInterface : tickables) {
            tickableInterface.onTick();
        }
    }


}
