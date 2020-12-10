import java.util.ArrayList;
import java.util.List;


public class CarModel {
    private List<Vehicle> vehicles = new ArrayList<>();

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.brake(brake);
        }
    }

    public void startEngine() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    public void stopEngine() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }

    /**
     * * hur ska vi använda turbo on/off när vi tar in alla bilar?
     **/

    public void setTurboOn() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOff();
            }
        }
    }

    public void scaniaLiftBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania) {
                ((Scania) v).raisePlatform(10);
            }
        }
    }

    public void scaniaLowerBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania) {
                ((Scania) v).lowerPlatform(10);
            }
        }
    }

    public void turnAroundCar(Vehicle vehicle) {

        double carX = vehicle.getPosition().getX();
        double frameX = frame.drawPanel.getSize().getWidth();

        if (carX > frameX - 110 || carX < 0) {
            vehicle.turn(Math.PI);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}

//frågor: hur når vi frame i CarModel? Har gjort en frame som ska representera instansen View i MVC-pattern.
// rad 62 i CarC: varför når den inte cm?
//