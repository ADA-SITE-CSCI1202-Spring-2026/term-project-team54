package com.team54.airportdispatchtycoonteam54.core.Services;

import java.util.ArrayList;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;

public class CrewManager {
    private static CrewManager INSTANCE;

    private final ArrayList<IGroundService> groundService =  new ArrayList<>();

    private String currentMessage;

    public CrewManager(){
        groundService.add(new BaggageHandler());
        groundService.add(new FuelingTruck());
        groundService.add(new CateringVan());
    }

    public static CrewManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CrewManager();
        }
        return INSTANCE;
    }


    /**
     * @return The message to be shown in the Dispatch Radio after the supply attempt is complete.
     */
    public String supplyFlight(FlightRequest flightRequest){
        String currentMessage = "";
        for (IGroundService service : groundService) {
            Integer neededSupplyAmount =
                    flightRequest.getAircraft().getSupplyAmountNeeded(service.getRequiredSupplyItem());

            if(service.canServiceFlight(neededSupplyAmount)){
                service.serviceFlight(flightRequest);
                currentMessage += service + " has successfully serviced the flight request.\n";
            }else{
                currentMessage += "Error: not enough " + service.getRequiredSupplyItem()
                        + " in the depot to service the flight request.\n";
                return currentMessage;
            }
        }
        return currentMessage;
    }

}
