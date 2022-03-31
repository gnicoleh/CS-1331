/* Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Nicole Hernandez
GT ID: 903760553
Date Due: 01-24-2022
Date Submitted: 01-23-2022
Fun Fact: The Saturday before classes started, on campus, I saw a hawk attempt to hunt a squirrel.

This program gives fixed values to variables 'euros', 'dollars', and 'notes'. Then calculates how
many euros and dollars there are. Then prints the output stating how many of each 'name' has.*/

public class CurrencyConversion {
    public static void main(String[] args) {
        double aedPerUsd = 3.67;
        double aedPerEur = 4.19;
        int notes = 250;
        String name = "Guisella";
        double euros = notes / aedPerEur;      //Java promotes notes to a float
        double dollars = notes / aedPerUsd;    //Java promotes notes to a float
        System.out.printf(name + " is carrying %.2f Euros and %.2f Dollars! \n", euros, dollars);
    }
}
