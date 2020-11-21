import java.awt.*;

public abstract class Car extends Vehicle {

    private int nrDoors; //Number of doors, not necessary in the other vehicles

    public Car(int Doors, Color c, double eP, String name) {
      super(c,eP, name );
      nrDoors = Doors;

    }

    void setNrDoors(int n) {
        this.nrDoors = n;
    }
    int getNrDoors() {
        return nrDoors;
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
    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() +speedFactor() * amount, getEnginePower()));
    }

    @Override
    /**
     * Minskar speed till minst '0'
     * @param amount mängden som vi vill minska med
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


}