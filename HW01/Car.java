/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Hernandez
Date Submitted: 02-21-2022
Date Due: 02-21-2022

-------Car Class--------

The Car class is made up of 6 private variables, 3 constructors, and 8 methods.

The behaviors of each Car object are: year, make, model, color, and conditionCategory.

The no-args contructor creates a Car object with predetermined values
for the 5 different behaviors.

The target constructor creates a Car object completely defined by the user.

The 3-argument constructor creates a Car object using the 3 arguments provided by the
user, anc complimenting the missing 2 with predetermined values.

An accessor was created for every behavior. The other 3 methods are helper methods.
Therefore, they were made private.
*/

public class Car {
    // Instance Variables
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    // Taget constructor
    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.conditionCategory = conditionCategory;
        printConditionCategoryScore(this.conditionCategory);
        setIsRestored(this.conditionCategory);
        getIsRestored();
    }

    // 3-argument constructor
    public Car(int year, String make, String model) {
        this(year, make, model, "blue", 80);
    }

    // No-args constructor
    public Car() {
        this(1960, "Jaguar", "E-Type", "silver", 89);
    }

    // --------Begin Accessor Methods--------
    public int getYear() {
        return this.year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getConditionCategory() {
        return this.conditionCategory;
    }

    // ---------Begin Helper Methods---------
    private void printConditionCategoryScore(int category) {
        if ((category >= 90) && (category <= 100)) {
            System.out.println("Perfect");
        } else if ((category >= 80) && (category < 90)) {
            System.out.println("Excellent");
        } else if ((category >= 70) && (category < 80)) {
            System.out.println("Fine");
        } else if ((category >= 60) && (category < 70)) {
            System.out.println("Very Good");
        } else if ((category >= 50) && (category < 60)) {
            System.out.println("Good");
        } else if ((category >= 40) && (category < 50)) {
            System.out.println("Driver");
        } else {
            this.conditionCategory = 80;
            System.out.println("Excellent");
        }
    }

    private void setIsRestored(int category) {
        this.isRestored = (category >= 90) ? true : false;
    }

    private boolean getIsRestored() {
        return this.isRestored;
    }
}
