import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Generisk klass som har typparameter (inom <>)
 */

public class CarRepair<RepairableType extends Car> {

    public Set<RepairableType> listOfCarsToRepair;
    final private int maxCapacity;


    public void addCar(RepairableType carInNeed) {
        if (listOfCarsToRepair.size() < maxCapacity) {
            listOfCarsToRepair.add(carInNeed);
        } else System.out.println("The repair shop is full");
    }

    public void removeCar(RepairableType finishedCar) {
        if (listOfCarsToRepair.contains(finishedCar)) {
            listOfCarsToRepair.remove(finishedCar);
        } else System.out.println("Your car is not here");

    }


    public CarRepair(int capacityInside) {
        this.maxCapacity = capacityInside;
        this.listOfCarsToRepair = new LinkedHashSet<RepairableType>(capacityInside);
    }


}



