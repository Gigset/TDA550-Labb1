import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; //Antal dörrar
    private Color color; //Färg på bil
    private double enginePower; //Motorns kraft
    private String modelName; //Namn på bil
    private double currentSpeed; //Hasitghet
    private double xPos, yPos;
    private double angle;

    protected Car(int nr, Color c, double eP, String name) {
        nrDoors = nr;
        color = c;
        enginePower = eP;
        modelName = name;
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
        enginePower = p;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    void setCurrentSpeed(double amount) {
        currentSpeed = currentSpeed + amount;
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

    abstract double speedFactor();

    void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    // TODO fix this method according to lab pm
    void gas(double amount) {
        if (amount > 1 || amount < 0) {
           System.out.print("Gas amount must be in the range 0-1");
            return;
        } else incrementSpeed(amount);
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

    //Förut hade vi turn(double angleChange), problem med accessen... vrf?
    public void turn(double angleChange) {
        angle = angle + angleChange;
    }
}
