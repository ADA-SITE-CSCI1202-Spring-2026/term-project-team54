package com.team54.airportdispatchtycoonteam54.core.Services;

import com.team54.airportdispatchtycoonteam54.core.Planes.Aircraft;
import com.team54.airportdispatchtycoonteam54.core.Queue.FlightRequest;
import com.team54.airportdispatchtycoonteam54.core.Resource.SupplyItem;

public interface IGroundService {

    void serviceFlight(FlightRequest flightRequest);

    /**
     * Returns true if the depo has enough of the given amount
     * of the required supply item.
     */
    Boolean canServiceFlight(Integer amount);

    /**
     *
     * @return The supply item that this Service uses for servicing the flight.
     */
    SupplyItem getRequiredSupplyItem();
}
