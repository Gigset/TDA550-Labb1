import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
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
        for (int i = 0; i < 1000; i++) {
            volvo.brake(1);
            saab.brake(1);
        }
        assertTrue(volvo.getCurrentSpeed() == 0 && saab.getCurrentSpeed() == 0);
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
        assertTrue(volvo.getCurrentSpeed() == volvo.getEnginePower() && saab.getCurrentSpeed() == saab.getEnginePower());
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
        assertTrue(volvo.getCurrentSpeed() == 0 && saab.getCurrentSpeed() == 0);
    }

    @Test
    public void testGetModelName() {
        assertTrue(volvo.getModelName().equals("Volvo240") && saab.getModelName().equals("Saab95"));
    }

    @Test
    public void testGetNrDoors() {
        assertTrue(volvo.getNrDoors() == 4 && saab.getNrDoors() == 2);
    }

    @Test
    public void setNrDoors() {
        volvo.setNrDoors(1);
        saab.setNrDoors(1);
        assertTrue(volvo.getNrDoors() == 1 && saab.getNrDoors() == 1);
    }

    @Test
    public void testGetColor() {
        assertTrue(volvo.getColor().equals(Color.black) && saab.getColor().equals(Color.red));
    }

    @Test
    public void testSetColor() {
        volvo.setColor(Color.green);
        assertTrue(volvo.getColor().equals(Color.green));
    }

    @Test
    public void testGetEnginePower() {
        assertTrue(volvo.getEnginePower() == 125 && saab.getEnginePower() == 125);
    }

    @Test
    public void testSetEnginePower() {
        volvo.setEnginePower(200);
        saab.setEnginePower(75);
        assertTrue(volvo.getEnginePower() == 200 && saab.getEnginePower() == 75);
    }

    @Test
    public void testMove() {
        volvo.turn(0);
        volvo.gas(1);
        for (int i = 0; i < 1000; i++) {
            volvo.move();
        }
        assertFalse(volvo.getPosition().getX() == 0);
    }

    @Test
    public void testTurn(){
        volvo.turn(3);
        assertTrue(volvo.getAngle() == 3);
    }
}