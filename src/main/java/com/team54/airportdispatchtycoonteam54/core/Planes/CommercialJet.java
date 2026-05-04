package com.team54.airportdispatchtycoonteam54.core.Planes;

// uses only fuel
public class CommercialJet extends Aircraft {

    public CommercialJet(){
        super(new AircraftNeeds(
                generateRandomSupplyItemNeed(10, 20), // fuel
                generateRandomSupplyItemNeed(10, 20), // meals
                0 // luggage
        ));
    }

}
