package com.team54.airportdispatchtycoonteam54.core.Services;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;



public class CateringVan implements IGroundService {

    public Boolean serviceFlight(Aircraft plane, SupplyItem item, Integer suppliedAmount) {
        if(item!=SupplyItem.MEAL)return false;
        System.out.println("Restocked " + suppliedAmount + " Meals for plane number: " + plane.getFlightNumber());
        return true;
    }
}

