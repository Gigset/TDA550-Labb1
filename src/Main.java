public class Main {
    public static void main(String[] args) {
        Car c1 = new Volvo240();
        Car c2 = new Saab95();

        c2.gas(2);
        System.out.println(c2.getCurrentSpeed());
        c2.brake(2);
        System.out.println(c2.getCurrentSpeed());
    }
}
