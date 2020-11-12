import java.awt.*;

/**
 * Abstract class Car using the interface Movable
 */

public abstract class Car implements Movable {
    private int nrDoors; //Antal dörrar
    private Color color; //Färg på bil
    private double enginePower; //Motorns kraft
    private String modelName; //Namn på bil
    private double currentSpeed; //Hasitghet
    private Point position;
    private double angle;

    /**
     * @param nr   nr of doors
     * @param c    Color
     * @param eP   enginepower
     * @param name model name
     */


    protected Car(int nr, Color c, double eP, String name) {
        nrDoors = nr;
        color = c;
        enginePower = eP;
        modelName = name;
        angle = 0;
        position = new Point(0, 0);
    }

    /**
     * Getters and setters to access private instance variables
     */

    Point getPosition() {
        return position;
    }

    double getAngle(){
        return angle;
    }

    String getModelName() {
        return modelName;
    }

    /**
     * @return
     */
    int getNrDoors() {
        return nrDoors;
    }

    void setNrDoors(int n) {
        nrDoors = n;
    }

    double getEnginePower() {
        return enginePower;
    }

    void setEnginePower(double p) {
        enginePower = p;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    //Sets the current speed, within [0, enginePower]
    private void setCurrentSpeed(double amount) {
        if (amount > getEnginePower()) {
            currentSpeed = getEnginePower();
        } else if (amount < 0) {
            currentSpeed = 0;
        } else currentSpeed = amount;
    }

    Color getColor() {
        return color;
    }

    void setColor(Color clr) {
        color = clr;
    }

    /**
     * Sets currentSpeed to 0.1
     */
    void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * sets currentSpeed to 0
     */
    void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Abstract method, defined in subclasses
     *
     * @return factor used in increment/decrementSpeed
     */
    abstract double speedFactor();

    /**
     * Increases speed by some value
     *
     * @param amount factor in new speed
     */
    void incrementSpeed(double amount) throws Exception {
        if (amount > 1 || amount < 0) {
            throw new Exception("Amount must be within 0-1");
        }
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decreases speed by some value
     *
     * @param amount factor in new speed
     */
    void decrementSpeed(double amount) throws Exception {
        if (amount > 1 || amount < 0) {
            throw new Exception("Amount must be within 0-1");
        }
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Increases speed with incrementSpeed()
     *
     * @param amount within 0-1
     */
    void gas(double amount) {
        try {
            incrementSpeed(amount);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }

    /**
     * Decreases speed with decrementSpeed()
     *
     * @param amount within 0-1
     */
    void brake(double amount) {
        try {
            decrementSpeed(amount);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }

    /**
     * Komposantuppdelning
     * Changes position according to angle and currentSpeed
     */
    public void move() {
        double xPos = position.getX() + getCurrentSpeed() * Math.cos(angle);
        double yPos = position.getY() + getCurrentSpeed() * Math.sin(angle);

        position.setLocation(xPos, yPos);
    }

    /**
     * changes current direction
     *
     * @param angleChange amount which you turn
     */
    public void turn(double angleChange) {
        angle = angle + angleChange;
    }
}
