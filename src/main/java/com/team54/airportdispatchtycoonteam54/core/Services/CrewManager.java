package com.team54.airportdispatchtycoonteam54.core.Services;

import java.util.ArrayList;

import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;

public class CrewManager {
    private static CrewManager INSTANCE;

    private final ArrayList<IGroundService> groundServices =  new ArrayList<>();

    private String currentMessage;

    public CrewManager(){
        groundServices.add(new BaggageHandler());
        groundServices.add(new FuelingTruck());
        groundServices.add(new CateringVan());
    }

    public static CrewManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CrewManager();
        }
        return INSTANCE;
    }


    /**
     * @return The message to be shown in the Dispatch Radio after the service attempt is complete.
     */
    public ServiceResult serviceFlight(FlightRequest flightRequest){
        if(flightRequest == null){
            return new ServiceResult(false, "ERROR: No flight request to service.\n");
        }
        String currentMessage = "";
        boolean canAllServicesSucceed = true;
        for (IGroundService service : groundServices) {
            Integer neededSupplyAmount =
                    flightRequest.getAircraft().getSupplyAmountNeeded(service.getRequiredSupplyItem());

            if(!service.canServiceFlight(neededSupplyAmount)) {
                canAllServicesSucceed = false;
                currentMessage = "Error: not enough " + service.getRequiredSupplyItem()
                        + " in the depot to service the flight request.\n";
                break;
            }
        }
        if(canAllServicesSucceed){
            for(IGroundService service: groundServices){
                service.serviceFlight(flightRequest);
                currentMessage += service + " has successfully serviced the flight request.\n";
            }
            currentMessage += "The flight request for " + flightRequest + " has been successfully cleared.\n";
        }
        return new ServiceResult(canAllServicesSucceed, currentMessage);
    }

}
