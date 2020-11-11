import java.awt.*;

public class Volvo240 extends Car{

    final static double trimFactor = 1.25;

    public Volvo240() {
       super(4,Color.black,125,"Volvo240");
        stopEngine();
    }

    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
