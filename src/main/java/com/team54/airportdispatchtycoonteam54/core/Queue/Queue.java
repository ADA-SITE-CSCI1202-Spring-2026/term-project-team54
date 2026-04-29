package com.team54.airportdispatchtycoonteam54.core.Queue;

public class Queue {
    private static int currentID=0;




    static int getNextID(){
        currentID++;
        return currentID;
    }
}
