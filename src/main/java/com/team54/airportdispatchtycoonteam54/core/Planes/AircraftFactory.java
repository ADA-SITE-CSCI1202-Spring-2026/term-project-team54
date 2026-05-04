package com.team54.airportdispatchtycoonteam54.core.Planes;

/**
 * Factory class for creating different Aircraft types.
*/
public abstract class AircraftFactory {
    /**
     * Returns an Aircraft class depending on the AIrcraftType.
    */
    public static <T extends Aircraft> T create(AircraftType type,AircraftNeeds AircraftNeeds){
        return switch (type) {
            case CARGO -> createCargoFreighter(AircraftNeeds);
            case COMMERCIAL -> createCommercialJet(AircraftNeeds);
            case PRIVATE -> createPrivateCharter(AircraftNeeds);
        };
    }

    /**
     * Private functions for creating Aircrafts.
    */


    private static PrivateCharter createPrivateCharter(AircraftNeeds AircraftNeeds){
        PrivateCharter privateCharter = new PrivateCharter(AircraftNeeds);
        return privateCharter;
    }


    private static CargoFreighter createCargoFreighter(AircraftNeeds AircraftNeeds){
        CargoFreighter cargoFreighter = new CargoFreighter(AircraftNeeds);
        return cargoFreighter;

    }

    private static CommercialJet createCommercialJet(AircraftNeeds AircraftNeeds){
        CommercialJet commercialJet = new CommercialJet(AircraftNeeds);
        return commercialJet;
    }

}
