package com.team54.airportdispatchtycoonteam54.core.Services;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public class FuelingTruck implements IGroundService {

    public Boolean serviceFlight(Aircraft plane, SupplyItem item, Integer supplyAmount) {
        if( item!=SupplyItem.FUEL ) return false;
        System.out.println("Fueled " + supplyAmount +"L of fuel to plane number: " + plane.getFlightNumber());
        return true;
    }
}

