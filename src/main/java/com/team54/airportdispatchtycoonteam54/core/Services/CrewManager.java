package com.team54.airportdispatchtycoonteam54.core.Services;

import java.util.ArrayList;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import com.team54.airportdispatchtycoonteam54.core.Resource.DepotManager;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public class CrewManager {
    private final ArrayList<IGroundService> groundService;
    private final DepotManager depotManager;

    public CrewManager(DepotManager depotManager){
        this.depotManager = depotManager;
        groundService = new ArrayList<>();
    }

    public void AddCrew(IGroundService crew){
        groundService.add(crew);
    }

    public void supplyPlane(Aircraft aircraft, SupplyItem supplyItem){
        Integer neededSupplyAmount = aircraft.getSupplyAmountNeeded(supplyItem);

        if(!depotManager.useSupply(supplyItem,neededSupplyAmount)) return;

        for (IGroundService service : groundService) {
            if(service.serviceFlight(aircraft, supplyItem, neededSupplyAmount)) break;
        }
    }    
}
