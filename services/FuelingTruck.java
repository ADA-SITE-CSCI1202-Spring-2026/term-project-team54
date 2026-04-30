public class FuelingTruck implements IGroundService {

    public void serviceFlight(Aircraft plane) {
        System.out.println("Fuel added to " + plane.getFlightNumber());
    }
}

