/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Hernandez
Date Submitted: 02-21-2022
Date Due: 02-21-2022

-------Garage Class--------

The Garage class is made up of 2 private variables, 2 constructors, and 3 methods.

The behaviors of each Garage object are: theOwner and carCatalogue.

The no-args contructor creates a Garage object with predetermined values
for the 2 different behaviors.

The target constructor creates a Garage object completely defined by the user.

The addCar() takes in 2 arguments and, if possible, adds a Car object into
carCatalogue in the provided index.

The sellCar() takes in 1 argument and, if possible, it removes the Car object
located in the provided index.

The showCertainCars() takes in 1 arguments and, if applicable, displays on the
console the Car objects meeting the criteria provided.
*/

public class Garage {
    // Instance variables
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    // Target constructor
    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    // No-args constructor
    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4];
    }

    // addCar Method || Car
    public Car addCar(int index, Car car) {
        Car previousCar = carCatalogue[index];
        carCatalogue[index] = car;
        if ((index >= 0 && index <= carCatalogue.length - 1) && (car != null)) {
            if (previousCar != null) {
                System.out.printf("There was a %s %d %s %s here before.\n",
                    previousCar.getColor(), previousCar.getYear(), previousCar.getMake(), previousCar.getModel());
            } else {
                System.out.printf("A %s %d %s %s was just parked here.\n",
                    car.getColor(), car.getYear(), car.getMake(), car.getModel());
            }
            int numCars = theOwner.getCarsOwned();
            theOwner.setCarsOwned(numCars + 1);
            return previousCar;
        } else {
            System.out.println("Cannot add a car to this spot.");
            return null;
        }
    }

    // sellCar Method || Car
    public Car sellCar(int index) {
        if ((index >= 0 && index <= carCatalogue.length - 1) && carCatalogue[index] != null) {
            Car carSold = carCatalogue[index];
            System.out.printf("%s just sold a %s %d %s %s.\n",
                theOwner.getName(), carSold.getColor(), carSold.getYear(), carSold.getMake(), carSold.getModel());
            carCatalogue[index] = null;
            int numCars = theOwner.getCarsOwned();
            theOwner.setCarsOwned(numCars - 1);
            return carSold;
        } else {
            System.out.println("There was no car to sell!");
            return null;
        }
    }

    // showCertainCars || void
    public void showCertainCars(int conditionCategory) {
        for (Car car : carCatalogue) {
            if (car != null && Math.round(car.getConditionCategory() / 10.0) * 10
                > Math.round(conditionCategory / 10.0) * 10) {
                System.out.printf("A %s %d %s %s with condition category of %d.\n",
                    car.getColor(), car.getYear(), car.getMake(), car.getModel(), car.getConditionCategory());
            }
        }
    }
}
