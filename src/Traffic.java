import java.util.ArrayList;

public class Traffic {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<VehicleCircle> vCircles = new ArrayList<VehicleCircle>();
    private int numVehicles;

    public Traffic() {
        addCar(490, 25, 1);
        addCar(475, 465, 10);
        addCar(25, 450,1);
        addCar(430, 560,10);
        addCar(25, 475, 1);
        addCar(520, 700, 10);
        addCar(90,1340, 1);
        addCar(560, 960, 10);
        addCar(365, 1340, 1);
        addCar(625, 980, 10);
        addCar(845, 1355, 1);
        addCar(690, 940, 10);
        addCar(865, 1355, 1);
        addCar(690, 825, 10);
        addCar(1250, 60, 1);
        addCar(585, 495, 10);
        addCar(960,20,1);

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
