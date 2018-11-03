import javafx.geometry.Pos;

import java.util.ArrayList;

public class Traffic {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private int numVehicles;

    /**
     * Tests whether or not the vehicle will collide with another vehicle
     * @ return dontGo true if the vehicle shouldn't go, false otherwise
     */
    public boolean willCrash() {
        return false;
    }

    //public ArrayList<>

    public ArrayList<Position> getPositions() {
        ArrayList<Position> positions = new ArrayList<Position>();
        for (Vehicle vehicle : vehicles) {
            positions.add(vehicle.getPos());
        }
        return positions;
    }

    public void addCar(int x, int y) {
        Vehicle car = new Vehicle(x, y, 1);
        if(!vehicles.contains(car)) {
            vehicles.add(car);
        }
    }

}
