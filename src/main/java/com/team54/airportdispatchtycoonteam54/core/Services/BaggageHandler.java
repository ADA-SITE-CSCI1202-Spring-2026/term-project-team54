
package com.team54.airportdispatchtycoonteam54.core.Services;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public class BaggageHandler implements IGroundService {

    public Boolean serviceFlight(Aircraft plane,SupplyItem item,Integer suppliedAmount) {
        if(item!=SupplyItem.LUGGAGE)return false;
        System.out.println("Supplied " + suppliedAmount + " Luggage to plane number: " + plane.getFlightNumber());
        return true;
    }
}

