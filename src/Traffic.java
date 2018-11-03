import java.util.ArrayList;

public class Traffic {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<VehicleCircle> vCircles = new ArrayList<VehicleCircle>();
    private int numVehicles;

    public Traffic() {
        addCar(512, 540, 10);
    }

    /**
     * Tests whether or not the vehicle will collide with another vehicle
     * @ return dontGo true if the vehicle shouldn't go, false otherwise
     */
    public boolean willCrash() {
        return false;
    }

    public void addCar(int x, int y, int priority) {
        Vehicle car = new Vehicle(x, y, priority);
        if(!vehicles.contains(car)) {
            vehicles.add(car);
        }
        if(!vCircles.contains(car.getVCircle())) {
            vCircles.add(car.getVCircle());
        }
    }

    public ArrayList<VehicleCircle> getVCircles() {
        return vCircles;
    }

    public void update() {
        for (Vehicle vehicle : vehicles) {
            vehicle.moveForward();
        }
    }

}
