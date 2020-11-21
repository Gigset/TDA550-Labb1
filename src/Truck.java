import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Abstract class, represents any type of truck platform
 */

abstract public class Truck extends Vehicle{

    public Truck(Color c, double eP, String name) {
       super(c, eP, name);
    }

    /**
     * Boolean that says if a platform is fully raised or not
     */
     boolean fullyRaised;

    /**
     * Getter for the variable fullyRaised
     * @return fullyRaised
     */
    public boolean isFullyRaised() {
        return fullyRaised;
    }

    /**
     * Setter for the boolean fullyRaised
     * @param bol true or false
     */
    public void setFullyRaised(boolean bol) {
        fullyRaised = bol;
    }
}
