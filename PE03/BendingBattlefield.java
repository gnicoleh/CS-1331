/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Nicole Hernandez
Date Submitted: 02/06/2022
Date Due: 02/07/2022

This program generates a random number of heroes from range [50, 100]. Then assigns each hero a random bending type
using the BendingType method from the enums file. Values for power and health are given to each hero at random, keeping
count of the number of heroes in the Alliance and the Fire Nation. The average of power and health for each side is then
calculated and the results are dispayed on the console. Finally, the winner is calculated using a given formula, and the
result is displayed.
*/

import java.util.Random;

public class BendingBattlefield {
    public static void main(String[] args) {
        Random rand = new Random();
        int numHeroes = rand.nextInt(51) + 50;
        double boomerangBoost = Math.round((3 + (6 - 3) * rand.nextDouble()) * 100.0) / 100.0;
        double averageFirePower, averageFireHealth, averageAlliancePower, averageAllianceHealth;
        averageFirePower = 0;
        averageFireHealth = 0;
        averageAlliancePower = 0;
        averageAllianceHealth = 0;
        System.out.printf("Selecting %d heroes.\n", numHeroes);
        int numFire = 0;
        int numAlliance = 0;
        for (int i = 0; i < numHeroes; i++) {
            BendingType heroType = BendingType.values()[rand.nextInt(5)];
            double health = Math.round((50 + (149 - 50) * rand.nextDouble()) * 100.0) / 100.0;
            double power = Math.round((41 + (120 - 41) * rand.nextDouble()) * 100.0) / 100.0;
            switch (heroType) {
            case FIRE:
                averageFireHealth += health;
                averageFirePower += power;
                numFire++;
                break;
            case NON_BENDER:
                power *= boomerangBoost;
                averageAllianceHealth += health;
                averageAlliancePower += power;
                numAlliance++;
                break;
            default:
                averageAllianceHealth += health;
                averageAlliancePower += power;
                numAlliance++;
                break;
            }
            System.out.printf("%s hero has been summoned by his army, adding %.2f power"
                + "and %.2f health to the army.\n", heroType, power, health);
        }
        averageFirePower /= numFire;
        averageFireHealth /= numFire;
        averageAlliancePower /= numAlliance;
        averageAllianceHealth /= numAlliance;
        System.out.printf("The Fire Nation has an average of %.2f power"
            + "and %.2f health.\n", averageFirePower, averageFireHealth);
        System.out.printf("The Alliance has an average of %.2f power"
            + "and %.2f health.\n", averageAlliancePower, averageAllianceHealth);
        double fireTotal = 2 * averageFirePower + 3 * averageFireHealth;
        double allianceTotal = 2 * averageAlliancePower + 3 * averageAllianceHealth;
        if (fireTotal > allianceTotal) {
            System.out.println("The Fire Nation won!");
        } else {
            System.out.println("The Alliance won!");
        }
    }
}
