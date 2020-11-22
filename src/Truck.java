import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Abstract class, represents any type of truck platform
 */

abstract public class Truck extends Vehicle {

    public Truck(Color c, double eP, String name) {
        super(c, eP, name);
    }

}
