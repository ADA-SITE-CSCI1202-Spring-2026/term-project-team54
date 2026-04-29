package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.util.LinkedList;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;

public class Queue {
    private static int currentID=0;


    static LinkedList<Aircraft> aircraftQueue = new LinkedList<>();


    static int getNextID(){
        currentID++;
        return currentID;
    }


    public static Aircraft getNextAircraft(){
        Aircraft nextAircraft = aircraftQueue.removeFirst();
        return nextAircraft;
    }

    public static LinkedList<Aircraft> getAircraftQueue(){
        return aircraftQueue;
    }

}
