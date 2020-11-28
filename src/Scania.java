import java.awt.*;

/**
 * Scania subclass to car, with private instance variable platform
 */
public class Scania extends Truck {

    private double currentInclineAngle;

    public Scania() {
        super(Color.CYAN, 300, "Scania");
        currentInclineAngle = 0;
    }

    public double getCurrentInclineAngle() {
        return currentInclineAngle;
    }

    /**
     * Method which raises callers platform by some amount
     *
     * @param angleChange amount which we increase platform incline
     */
    public void raisePlatform(double angleChange) {
        currentInclineAngle = Math.min(70, currentInclineAngle += angleChange);
    }

    /**
     * Method which lowers active platform by some amount
     *
     * @param angleChange amount which we decrease platform incline
     */
    public void lowerPlatform(double angleChange) {
        currentInclineAngle = Math.max(0, currentInclineAngle -= angleChange);
    }

    /**
     * Overrides inherited method gas from vehicle, first checks if platform is lowered, then calls gas
     *
     * @param amount how much we increase speed
     */
    @Override
    public void gas(double amount) {
        if (getCurrentInclineAngle() > 0) {
            System.out.println("Lower platform before gas");
        } else {
            super.gas(amount);
        }
    }


    /**
     * Method which raises the incline by some amount
     * First checks for negative numbers
     * calculates new angle, sets current angle to min(70, calculated angle)
     * updates fullyRaised
     *
     * @param angleChange amount which platform is raised by
     */
    public void raise(double angleChange) {
        if (angleChange < 0) {
            System.out.println("angleChange can't be a negative number");
        }

        double newInclineAngle = currentInclineAngle + angleChange;

        if (newInclineAngle > 70) {
            currentInclineAngle = 70;
        } else currentInclineAngle = newInclineAngle;

    }

    /**
     * Method which lowers the incline by some amount
     * First checks for negative numbers
     * calculates new angle, sets current angle to max(0, calculated angle)
     * updates fullyRaised
     *
     * @param angleChange amount which platform is lowered by
     */
    public void lower(double angleChange) {
        if (angleChange < 0) {
            System.out.println("angleChange can't be a negative number");
        }

        double newInclineAngle = currentInclineAngle - angleChange;

        if (newInclineAngle < 0) {
            currentInclineAngle = 0;
        } else currentInclineAngle = newInclineAngle;
        
    }

    /**
     * Setter for current incline
     *
     * @param newIncline what new incline is
     */
    public void setCurrentInclineAngle(double newIncline) {
        currentInclineAngle = Math.min(newIncline, 70);
    }
}


