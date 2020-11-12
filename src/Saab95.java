import java.awt.*;

/**
 * Subclass Saab95 inherits from Car
 */

public class Saab95 extends Car {

    boolean turboOn;

    /**
     * Constructor
     */

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return factor depending on enginePower and turbo
     */

    double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
