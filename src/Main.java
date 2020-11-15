import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) {
        Scania vårScania = new Scania();
        Car volvo = new Volvo240();

        Point2D.Double p = new Point2D.Double(Math.PI, Math.exp(1));
        volvo.setPosition(p);
        try {
            vårScania.raisePlatform(25);
        } catch (Exception e) {
        }

        vårScania.turn(1);
        vårScania.gas(1);
        vårScania.move();
        System.out.println(vårScania.getPosition());

    }
}
