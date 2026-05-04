package com.team54.airportdispatchtycoonteam54.core.Planes;

import java.util.Random;

// uses Luggage and Fuel
public class CargoFreighter extends Aircraft {

    public CargoFreighter(){
        super(generateNeeds());
    }

    @Override
    public String toString() {
        return "Cargo Freighter #" + getFlightNumber();
    }

    private static AircraftNeeds generateNeeds() {
        final int MIN_LUGGAGE = 10;
        final int MAX_LUGGAGE = 20;
        final int MIN_FUEL = 10;
        final int MAX_FUEL = 20;

        int fuelNeeded = generateRandomSupplyItemNeed(MIN_FUEL, MAX_FUEL);
        int luggageNeeded = generateRandomSupplyItemNeed(MIN_LUGGAGE, MAX_LUGGAGE);

        return new AircraftNeeds(fuelNeeded, 0, luggageNeeded);
    }
}
