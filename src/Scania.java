public class Scania extends Car{

    public Scania(){
        super(2, color.purple, 300, "Scania");

    }

    @Override
    double speedFactor() {
        return 0;
    }
}
