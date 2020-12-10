import java.awt.geom.Point2D;

public class Application {
    public static void main(String[] args) {
        // Instances of this class
        CarController cc = new CarController();
        CarModel cm = new CarModel();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        for (int i = 0; i < cc.vehicles.size(); i++) {
            cc.vehicles.get(i).setPosition(new Point2D.Double(10, i * 100));

        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cm);

        // Start the timer
        cc.timer.start();
    }
}
