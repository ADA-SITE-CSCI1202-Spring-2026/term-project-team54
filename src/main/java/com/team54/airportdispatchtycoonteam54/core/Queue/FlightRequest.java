package com.team54.airportdispatchtycoonteam54.core.Queue;

import java.util.Random;
import com.team54.airportdispatchtycoonteam54.core.Planes.*;








public class FlightRequest {


    Aircraft aircraft;

    public FlightRequest(){
        aircraft = FlightGenerator.generateRandom();
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
    
    
    private class FlightGenerator {


        private static final Random random = new Random();

        public static Aircraft generateRandom(){
            AircraftType type = AircraftType.values()[random.nextInt(AircraftType.values().length)];
            
            
            
            int neededFuel = random.nextInt(200, 1000);
            int neededMeals = random.nextInt(10, 100);
            int neededLuggage = random.nextInt(10,200);

            AircraftNeeds needs = new AircraftNeeds(neededFuel,neededMeals,neededLuggage);

            Aircraft generatedAircraft =  AicraftFactory.create(type,needs);
            
            

            return generatedAircraft;
        }

    }

}
