/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Hernandez
Date Submitted: 02-21-2022
Date Due: 02-21-2022

-------GarageOwner Class--------

The GarageOwner class is made up of 3 private variables, 1 constructor, and 4 methods.

The behaviors of each GarageOwner object are: name, age, and carsOwned.

The constructor creates a GarageOwner object using the 2 arguments provided by the
user, initiating carsOwned to 0 when the object is created.

An accessor was created for every behavior. A mutator was created for carsOwwned.
*/

public class GarageOwner {
    // Instance Variables
    private String name;
    private int age;
    private int carsOwned;

    // Constructor
    public GarageOwner(String name, int age) {
        this.name = name;
        this.age = age;
        this.carsOwned = 0;
    }

    // ------Mutator Method------
    public void setCarsOwned(int cars) {
        this.carsOwned = cars;
    }

    // ------Begin Accessor Methods-----
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getCarsOwned() {
        return this.carsOwned;
    }
}
