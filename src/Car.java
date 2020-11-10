import java.awt.*;

public abstract class Car implements Movable {
    protected int nrDoors; //Antal dörrar
    protected Color color; //Färg på bil
    protected double enginePower; //Motorns kraft
    protected String modelName; //Namn på bil
    protected double currentSpeed; //Hasitghet
    protected double xPos, yPos;
    protected double angle;

    protected Car(){
        angle = 0;
        xPos = 0;
        yPos = 0;
    }

    //Skapar metoder för att komma runt privata instansvariabler i super
    String getModelName() {
        return this.modelName;
    }

    int getNrDoors() {
        return nrDoors;
    }

    void setNrDoors(int n) {
        this.nrDoors = n;
    }

    double getEnginePower() {
        return enginePower;
    }

    void setEnginePower(double p) {
        this.enginePower = p;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    Color getColor() {
        return color;
    }

    void setColor(Color clr) {
        color = clr;
    }

    void startEngine() {
        currentSpeed = 0.1;
    }

    void stopEngine() {
        currentSpeed = 0;
    }

    double speedFactor(double amount) {
        return 0;
    }

    void incrementSpeed(double amount) {
    }

    void decrementSpeed(double amount) {
    }

    // TODO fix this method according to lab pm
    void gas(double amount) {

        if (amount < 0 || amount > 1){

        }

        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    void brake(double amount) {
        decrementSpeed(amount);
    }

    public void move() {
        //Komposantuppdelning
        xPos = xPos + getCurrentSpeed() * Math.cos(angle);
        yPos = yPos + getCurrentSpeed() * Math.sin(angle);
    }

    public void turn(double angleChange) {
        angle = angle + angleChange;
    }

}
