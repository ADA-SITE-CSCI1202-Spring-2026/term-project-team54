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
            int type = random.nextInt(3);
            
            Aircraft generatedAircraft = null;


            float neededFuel = random.nextFloat(200, 1000);
            int neededMeals = random.nextInt(20, 100);


            switch (type) {
                case 1:
                    generatedAircraft = new CargoFreighter(
                        Queue.getNextID(),
                        neededFuel,
                        neededMeals
                    );
                    break;
                case 2:
                    generatedAircraft = new PrivateCharter(
                        Queue.getNextID(),
                        neededFuel,
                        neededMeals
                    );
                    break;
                case 0:
                    generatedAircraft = new CommercialJet(
                        Queue.getNextID(),
                        neededFuel,
                        neededMeals
                    );
                    break;
            }


            return generatedAircraft;
        }

    }

}
