import java.awt.*;

public abstract class Car {
    private int nrDoors; //Antal dörrar
    private Color color; //Färg på bil
    private double enginePower; //Motorns kraft
    private String modelName; //Namn på bil
    private double currentSpeed; //Hasitghet

    //Skapar metoder för att komma runt privata instansvariabler i super
    String getModelName(){
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
}
