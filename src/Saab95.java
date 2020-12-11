import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Subclass Saab95 inherits from Car
 */

public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Constructor
     */

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
        position = new Point(0, 0);
    }

    public void setTurboOn() {
        turboOn = true;
    }

    /**
     *
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return factor depending on enginePower and turbo
     */

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 2.5;
        return getEnginePower() * 0.01 * turbo;
    }

}
