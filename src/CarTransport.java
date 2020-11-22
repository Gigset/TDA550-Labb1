import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class CarTransport extends Truck {

    /**
     * List for cars loaded on the platform.
     */
    final private List<Car> carsOnPlatform;
    final private int maxCapacity;

    private boolean platformRaised;

    /**
     * Constructor
     *
     * @param c    color
     * @param eP   enginePower
     * @param name name
     */
    public CarTransport(Color c, double eP, String name, int max) {
        super(c, eP, name);
        maxCapacity = max;
        platformRaised = true;
        carsOnPlatform = new ArrayList<Car>();
    }

    /**
     * Method to raise the platform
     */
    private void setPlatformRaised(boolean bol) {
        platformRaised = bol;
    }

    public boolean isPlatformRaised() {
        return platformRaised;
    }

    /**
     * method to set the platform down. This is impossible unless the speed is zero.
     */
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            setPlatformRaised(false);
        } else System.out.println("Speed has to be zero to set platform down");
    }

    /**
     * Method to raise the platform
     */
    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            setPlatformRaised(true);
        } else System.out.println("Speed has to be zero to set platform down");
    }

    /**
     * Method deltaDistance uses Pythagoras.
     *
     * @return the distance from the car and the car transport
     */
    private double deltaDistance(Car c) {
        double deltaX = Math.abs(c.getPosition().getX() - getPosition().getX());
        double deltaY = Math.abs(c.getPosition().getY() - getPosition().getY());

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    /**
     * loads a car if the platform is down, there is space and the car is close enough (chose 3 l.e)
     *
     * @param c a car
     */
    public void loadCar(Car c) {
        if (!platformRaised && deltaDistance(c) <= 3 && getCarsOnPlatform() < maxCapacity) {
            carsOnPlatform.add(c);
            c.setPosition(getPosition());
        } else System.out.println("You can't load this car");
    }

    /**
     * Overriding the method move and adding some features to make sure
     * the cars on platform moves with the same speed as the car transport.
     * (so they´re in the same position)
     */
    @Override
    public void move() {
        super.move();
        for (Car c : carsOnPlatform)
            c.setPosition(getPosition());
    }

    /**
     * Skapar temporär bil.skapar en till referens till sista bilen. Möjligt pga kan ha flera pekare mot samma objekt.
     * Vi tar bort den senast tillagda bilen, och det anges mha index.
     * Placerar bilen 2 l.e. från lastbilen vid avlastning.
     */
    public void unloadCar() {
        if (!platformRaised) {
            Car c = carsOnPlatform.get(carsOnPlatform.size() - 1);
            c.setPosition(new Point2D.Double(getPosition().getX() + 2, getPosition().getY()));

            carsOnPlatform.remove(carsOnPlatform.size() - 1);

        }
    }

    public int getCarsOnPlatform() {
        return carsOnPlatform.size();
    }
}


