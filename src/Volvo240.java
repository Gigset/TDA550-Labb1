import java.awt.*;

/**
 * Subclass Volvo240 inherits from Car
 */
public class Volvo240 extends Car{

    final static double trimFactor = 1.25;

    /**
     * Constructor
     */
    public Volvo240() {
       super(4,Color.black,125,"Volvo240");
    }

    /**
     * @return factor depending on enginePower and trimFactor
     */
    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
