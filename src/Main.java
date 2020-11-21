import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) {
        Scania vårScania = new Scania();
        Car volvo = new Volvo240();
        Car Volvo = volvo;
        Car tamisvolvo = new Volvo240();


        Volvo240 böttadvolvo = new Volvo240();
        Saab95 trimmadSaab = new Saab95();

        Point2D.Double p = new Point2D.Double(Math.PI, Math.exp(1));
        volvo.setPosition(p);
        try {
            vårScania.raisePlatform(25);
        } catch (Exception e) {
        }

        CarRepair EllafixarAB = new CarRepair(7);

        EllafixarAB.addCar(volvo);
        EllafixarAB.addCar(Volvo);

        EllafixarAB.removeCar(tamisvolvo);
       for(Object e : EllafixarAB.listOfCarsToRepair)
           System.out.println(e) ;





    }
}
