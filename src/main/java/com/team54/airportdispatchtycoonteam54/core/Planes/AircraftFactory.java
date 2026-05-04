package com.team54.airportdispatchtycoonteam54.core.Planes;

/**
 * Factory class for creating different Aircraft types.
*/
public abstract class AircraftFactory {

    /**
     * Returns an Aircraft instance depending on the AircraftType.
    */
    @SuppressWarnings("unchecked")
    public static <T extends Aircraft> T create(AircraftType type) {
        return (T) switch (type) {
            case CARGO -> new CargoFreighter();
            case COMMERCIAL -> new CommercialJet();
            case PRIVATE -> new PrivateCharter();
        };
    }

}
