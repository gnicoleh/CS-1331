/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Hernandez
Date Due: 01-31-2022
Date Submitted: 01-30-2022

This program consists of 2 parts:
Part 1: An arbitrary number in decimal (1-1000) is assigned to an int variable and a termanry string representation in created
by calculating the modulo and then divind the chosen number by 3. Using a while loop to iterate until the number chosen is reduced to 0.
The while loop keeps track of the total number of 0's, 1's, and 2's for each iteration, and stores the total amount in 3 different variables.
Part 2: Displays information on the console about the ternary representation.
*/

public class Ternary {
    public static void main(String[] args) {
        int initialNum = 7;
        String answer = "";
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        int currentNum = initialNum;
        System.out.println(initialNum);

        while (currentNum != 0) {
            int digit = currentNum % 3;
            if (digit == 0)
                zeroCount++;
            else if (digit == 1)
                oneCount++;
            else twoCount++;
            answer = digit + answer;
            currentNum /= 3;
        }
        System.out.println("Decimal representation: " + initialNum);
        System.out.println("Ternary representation: " + answer);
        System.out.println(zeroCount + " zeros, " + oneCount + " ones, and " + twoCount + " twos");

        int digitSum = 1 * oneCount + 2 * twoCount;
        switch (digitSum % 5) {
        case 0:
            System.out.println("The ternary digits sum to a multiple of 5!");
            break;
        case 1:
            System.out.println("The ternary digits almost summed to a multiple 5!");
            break;
        case 4:
            System.out.println("So close!");
            break;
        default: System.out.println("Nope!");
        }
    }
}
