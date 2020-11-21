import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class CarTransport extends Truck {

    /**
     * List for cars loaded on the platform.
     */
    private List<Car> carsOnPlatform ;
    /**
     *
     */
   private boolean platformRaised;
    /**
     * Constructor
     * @param c color
     * @param eP enginePower
     * @param name name
     */
    public CarTransport(Color c, double eP, String name) {
        super(c, eP, name);
        platformRaised = true ;
      carsOnPlatform = new ArrayList<Car>();
    }

    /**
     * Method to raise the platform
     * @return true
     */
    public void setPlatformRaised(){
        this.platformRaised = true;
    }

    /**
     * method to set the platform down. This is impossible unless the speed is zero.
     */
    public void setPlatformDown() {
        if (this.getCurrentSpeed() == 0) {
            this.platformRaised = false;
        } else System.out.println("Speed has to be zero to set platform down");
    }

    /**
     * Method to raise the platform
     * @return true
     */
    public boolean getPlatformUp(){
        return this.platformRaised;
    }

    /**
     * Method deltaDistance uses Pythagoras.
     * Hur vet den vilken bil?
     * @return the distance from the car and the car transport
     */
    private double deltaDistance(Car c){
        double deltaX = Math.abs(c.getPosition().getX() - this.getPosition().getX());
        double deltaY = Math.abs(c.getPosition().getY() - this.getPosition().getY());

        return Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
    }

    /**
     * loads a car if the platform is down and the car is close enough (chose 3 l.e)
     * @param c a car
     */
    public void loadCar(Car c){
        if(this.platformRaised == false && this.deltaDistance(c) <= 3 ) {
            carsOnPlatform.add(c);
            c.setPosition(this.getPosition());
        } else System.out.println("Lower your platform before loading cars, or move the car closer to the truck");
    }

    /**
     * Overriding the method move and adding some features to make sure
     * the cars on platform moves with the same speed as the car transport.
     * (so they´re in the same position)
     */
    @Override
    public void move(){
        super.move();
        for(Car c:carsOnPlatform)
                c.setPosition(this.getPosition());
    }

    /**
     * Skapar temporär bil.skapar en till referens till sista bilen. Möjligt pga kan ha flera pekare mot samma objekt.
     * Vi tar bort den senast tillagda bilen, och det anges mha index.
     * Placerar bilen 2 l.e. från lastbilen vid avlastning.
     */
    public void unloadCar(){
        if(this.platformRaised == false) {
            Car c = carsOnPlatform.get(carsOnPlatform.size()-1);
            c.setPosition(new Point2D.Double(this.getPosition().getX() + 2, this.getPosition().getY()));

            carsOnPlatform.remove(carsOnPlatform.size() - 1);

        }
    }
    public int getCarsOnPlatform() {
        return this.carsOnPlatform.size();
    }
}


