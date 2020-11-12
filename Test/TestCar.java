import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCar {

    Car volvo = new Volvo240();
    Car saab = new Saab95();

    @Test
    public void testGasVolvoSaab() {
        for (int i = 0; i < 1000; i++) {
            volvo.gas(1);
            saab.gas(1);
        }
        assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower() && saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testBrakeVolvoSaab() {
        for (int i = 0; i < 1000; i++) {
            volvo.gas(1);
            saab.gas(1);
        }
        volvo.brake(1);
        saab.brake(1);
        assertTrue(volvo.getCurrentSpeed() < volvo.getEnginePower() && saab.getCurrentSpeed() < saab.getEnginePower());
    }

    @Test
    public void testStartEngine() {
        for (int i = 0; i < 1000; i++) {
            volvo.startEngine();
            saab.startEngine();
        }
        assertTrue(volvo.getCurrentSpeed() == 0.1 && saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine() {
        for (int i = 0; i < 1000; i++) {
            volvo.gas(1);
            saab.gas(1);
        }
        volvo.stopEngine();
        saab.stopEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.0 && saab.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testIncrementSpeed() {
        for (int i = 0; i < 1000; i++) {
            try {
                volvo.incrementSpeed(1);
                saab.incrementSpeed(1);
            } catch (Exception E) {
            }
        }
    }

    @Test
    public void testDecrementSpeed() {
        for (int i = 0; i < 1000; i++) {
            try {
                volvo.decrementSpeed(1);
                saab.decrementSpeed(1);
            } catch (Exception E) {
            }
        }
    }
}