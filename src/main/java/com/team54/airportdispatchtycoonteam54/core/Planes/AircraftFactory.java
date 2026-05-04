package com.team54.airportdispatchtycoonteam54.core.Planes;

import com.team54.airportdispatchtycoonteam54.core.Queue.Queue;

// import com.team54.airportdispatchtycoonteam54.core.Queue.Queue;






/**
 * Factory class for creating different Aircraft types.
*/
public class AircraftFactory {
    /**
     * Returns an Aircraft class depending on the AIrcraftType.
    */
    public static Aircraft create(AircraftType type,AircraftNeeds AircraftNeeds){
        switch (type) {
            case CARGO:
                return createCargoFreighter(AircraftNeeds);
            case COMMERCIAL:
                return createCommercialJet(AircraftNeeds);
            case PRIVATE:
                return createPrivateCharter(AircraftNeeds);
            default:
                return createPrivateCharter(AircraftNeeds);        
        }
    }

    /**
     * Private functions for creating Aircrafts.
    */


    private static PrivateCharter createPrivateCharter(AircraftNeeds AircraftNeeds){
        PrivateCharter privateCharter = new PrivateCharter(Queue.getNextID(), AircraftNeeds);
        return privateCharter;
    }


    private static CargoFreighter createCargoFreighter(AircraftNeeds AircraftNeeds){
        CargoFreighter cargoFreighter = new CargoFreighter(Queue.getNextID(), AircraftNeeds);
        return cargoFreighter;

    }

    private static CommercialJet createCommercialJet(AircraftNeeds AircraftNeeds){
        CommercialJet commercialJet = new CommercialJet(Queue.getNextID(), AircraftNeeds);
        return commercialJet;
    }

}
