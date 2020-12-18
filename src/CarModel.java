import java.util.ArrayList;
import java.util.List;


public class CarModel implements Observer {
    protected List<Vehicle> vehicles = new ArrayList<>();
    private CarFactory factory = new CarFactory();


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

    //vad ska skrivas i denna for each-loopen? blir det lixom cirkulärt med anropen? samma med removeCar
    public void addCar() {

        if (vehicles.size() <= 10) {
            Vehicle toBeAdded = factory.createSaab95();
            vehicles.add(toBeAdded);

        } else System.out.println("You cannot add another car because there are already 10 cars.");
    }

    public void removeCar() {
        if (vehicles.size() >= 0) {

            vehicles.remove((vehicles.size() - 1));

        } else System.out.println("you have no cars");
    }


    public void turnAroundCar(Vehicle vehicle) {

        double carX = vehicle.getPosition().getX();
        //   double frameX = frame.drawPanel.getSize().getWidth();
        double frameX = 1000;
        if (carX > frameX - 110 || carX < 0) {
            vehicle.turn(Math.PI);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public void refresh() {
        for (Vehicle vehicle : vehicles) {

            turnAroundCar(vehicle);
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition().getX());
            int y = (int) Math.round(vehicle.getPosition().getY());
        }
    }
}
