public class CateringVan implements IGroundService {

    public void serviceFlight(Aircraft plane) {
        System.out.println("Meals added to " + plane.getFlightNumber());
    }
}

