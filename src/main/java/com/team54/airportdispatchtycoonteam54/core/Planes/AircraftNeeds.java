package com.team54.airportdispatchtycoonteam54.core.Planes;

    
public class AircraftNeeds{


        public AircraftNeeds(Float fuel, Integer meals, Integer luggage){
            requiredFuel = fuel;
            requiredMeals = meals;
            requiredLuggage = luggage;

        }

        Float requiredFuel;
        Integer requiredMeals;
        Integer requiredLuggage;
    }