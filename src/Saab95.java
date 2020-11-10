import java.awt.*;

public class Saab95 extends Car {

    boolean turboOn;

    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
    }

    void setTurboOn() {
        turboOn = true;
    }

    void setTurboOff() {
        turboOn = false;
    }

    double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    void brake(double amount) {
        decrementSpeed(amount);
    }

}
