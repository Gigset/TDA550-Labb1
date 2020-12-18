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

public class CarController {
    // member fields:
    protected CarModel model;

    //behöver konstruktor här för att veta vad controllern ska styra (vilken model)
    //allt som händer med knappar ska skickas till carC och sen skickas direkt vidare till carM. Som en mellanhand.
    protected CarController(CarModel carmodel) {
        this.model = carmodel;
//hit ska det skickas från carview och slussas vidare till modellen.
// Controller anropar metoder i model när den får en signal från viewen.
    }
    //methods to send signal from view to model:

    protected void brake(int amount) {
        model.brake(amount);
    }


    protected void gas(int amount) {
        model.gas(amount);
    }

    protected void startEngine() {
        model.startEngine();
    }

    protected void stopEngine() {
        model.stopEngine();
    }

    protected void setTurboOn() {
        model.setTurboOn();
    }

    protected void setTurboOff() {
        model.setTurboOff();
    }

    protected void scaniaLiftBed() {
        model.scaniaLiftBed();
    }

    protected void scaniaLowerBed() {
        model.scaniaLowerBed();
    }

    protected void removeCar() {
        model.removeCar();
    }

    protected void addCar() {
        model.addCar();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
}

