import java.awt.*;

/**
 * Scania subclass to car, with private instance variable platform
 */
public class Scania extends Car {

    final private ScaniaPlatform platform;


    public Scania() {
        super(2, Color.CYAN, 300, "Scania");
        platform = new ScaniaPlatform();
    }

    /**
     *Method which raises callers platform by some amount
     * @param angleChange amount which we increase platform incline
     * @throws Exception throws e if we try to raise by a negative number
     */
    public void raisePlatform(double angleChange) throws Exception {
        platform.raise(angleChange);
    }

    /**
     *Method which lowers active platform by some amount
     * @param angleChange amount which we decrease platform incline
     * @throws Exception throws e if we try to lower by a negative number
     */
    public void lowerPlatform(double angleChange) throws Exception {
        platform.lower(angleChange);
    }

    /**
     * Overrides inherited method gas from car, first checks if platform is lowered, then calls gas
     * @param amount how much we increase speed
     */
    @Override
    public void gas(double amount) {
        if (platform.getCurrentIncline() > 0) {
            System.out.println("Lower platform before gas, ditt flarn");
        } else {
            super.gas(amount);
        }
    }


    /**
     * Scania has a constant speedFactor of 1.4
     * @return 1.4
     */
    @Override
    double speedFactor() {
        return 1.4;
    }
}
