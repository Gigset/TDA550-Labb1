import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) {
        Scania vårScania = new Scania();
        Car Volvo = new Volvo240();

        Car tamisvolvo = new Volvo240();


        Volvo240 böttadvolvo = new Volvo240();
        Saab95 trimmadSaab = new Saab95();

        Point2D.Double p = new Point2D.Double(Math.PI, Math.exp(1));
        Volvo.setPosition(p);

        CarRepair<Volvo240> EllafixarAB = new CarRepair(7);

        EllafixarAB.addCar((Volvo240) Volvo);
    }
}