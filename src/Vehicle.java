import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Abstract class Car using the interface Movable
 */

//flyttade upp hela Car-klassen in i Vehicle, för att både truck och car ska kunna ärva detta.
public abstract class Vehicle implements Movable {

    private Color color; //Color of car
    private double enginePower; //double engine power
    private final String modelName; //String model name
    private double currentSpeed; //double current speed
    protected Point2D.Double position; //Point position
    private double dirAngle; //double directional angle, radians

    /**
     * @param c    Color
     * @param eP   engine power
     * @param name model name
     */


    protected Vehicle(Color c, double eP, String name) {
        color = c;
        enginePower = eP;
        modelName = name;
        dirAngle = 0;
        position = new Point2D.Double(0, 0);
    }

    /**
     * Getters and setters to access private instance variables
     */

    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double newPos) {
        position = newPos;
    }

    double getDirAngle() {
        return dirAngle;
    }

    String getModelName() {
        return modelName;
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
    protected void setCurrentSpeed(double amount) {
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
     * Minskar speed till minst '0'
     * @param amount mängden som vi vill minska med
     */
    public void decrementSpeed(double amount) {

        currentSpeed = Math.max(getCurrentSpeed() - amount, 0);
    }


    /**
     * Decreases speed by some value
     *
     * @param amount factor in new speed
     */
    public void incrementSpeed(double amount) {

        currentSpeed = Math.min(getCurrentSpeed() + amount, enginePower);
    }

    /**
     * Increases speed with incrementSpeed()
     *
     * @param amount within 0-1
     */
    public void gas(double amount) {
       if(amount>=0 && amount<=1 ) {
               incrementSpeed(amount);
           }else throw new RuntimeException("invalid number");
    }

    /**
     * Decreases speed with decrementSpeed()
     *
     * @param amount within 0-1
     */
    public void brake(double amount) {
        if(amount>=0 && amount<=1 ) {
            decrementSpeed(amount);
        }else throw new RuntimeException("invalid number");
        }


    /**
     * Changes position according to dirAngle and currentSpeed
     */
    public void move() {
        double xPos = position.getX() + getCurrentSpeed() * Math.cos(dirAngle);
        double yPos = position.getY() + getCurrentSpeed() * Math.sin(dirAngle);

        position.setLocation(xPos, yPos);
    }

    /**
     * changes current direction
     *
     * @param angleChange amount which you turn
     */
    public void turn(double angleChange) {
        dirAngle = dirAngle + angleChange;
    }
}
