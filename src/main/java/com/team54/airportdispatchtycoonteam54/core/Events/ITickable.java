package com.team54.airportdispatchtycoonteam54.core.Events;



// Interface implemented by a class that needs to use the Tick system.
public interface ITickable {


    void onTick();



    /**
     * Adds instance with the ITickable interface to the TickSingleton tickables List so the 
     * onTick method is called every tick.
     */
    default void subscribe(){
        if(TickSingleton.instance==null)return;
        TickSingleton.addITickable(this);
    }
    
}
