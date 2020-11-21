import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Generisk klass som har typparameter (inom <>)
 */

public class CarRepair <RepairableType extends Car > {

    /**
     *
     */
    public Set<RepairableType> listOfCarsToRepair;
    private int maxCapacity;



    public void addCar(RepairableType carInNeed){
       if(listOfCarsToRepair.size() < maxCapacity) {
           listOfCarsToRepair.add(carInNeed);
       } else System.out.println("Såhär många bilar kan jag inte hantera");
    }

    public void removeCar(RepairableType finishedCar){
       if(listOfCarsToRepair.contains(finishedCar)){
           listOfCarsToRepair.remove(finishedCar);
       } else System.out.println("du har ju inte ens din bil" + finishedCar + "här");

    }


    public CarRepair ( int capacityInside ){
        this.maxCapacity = capacityInside ;
        this.listOfCarsToRepair = new LinkedHashSet<RepairableType>(capacityInside);
    }



}



