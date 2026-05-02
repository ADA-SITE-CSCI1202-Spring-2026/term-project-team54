package com.team54.airportdispatchtycoonteam54.core.Events;




// Interface implemented by a class that needs to use the Tick system.
public interface TickableInterface {
    static TickableInterface[] tickables = {};

    void onTick();

    public static void callTick(){
        for (TickableInterface tickableInterface : tickables) {
            tickableInterface.onTick();
        }
    } 
    
}
