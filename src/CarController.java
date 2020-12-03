import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

// var fasen är konstruktorn??


public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    private List<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        for (int i = 0; i < cc.vehicles.size(); i++) {
            cc.vehicles.get(i).setPosition(new Point2D.Double(0, i * 100));
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {

                checkPosition(vehicle);
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles
        ) {
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


    public void checkPosition(Vehicle vehicle) {

        double carX = vehicle.getPosition().getX();
        double frameX = frame.drawPanel.getSize().getWidth();

        if (carX > frameX - 110 || carX < 0) {
            vehicle.turn(Math.PI);
        }

        //     if (carY > (frameY - 110) || carY < 0) {
        //       vehicle.turn(Math.PI);
        // }
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
