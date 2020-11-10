import java.awt.*;

public class Volvo240 extends Car {

    final static double trimFactor = 1.25;

    public Volvo240() {

        nrDoors = 4;
        color = Color.black;
        enginePower = 125;
        modelName = "Volvo240";
        stopEngine();
    }

    double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
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
