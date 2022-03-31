/* Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Nicole Hernandez
GT ID: 903760553
Date Due: 01-24-2022
Date Submitted: 01-23-2022

This program gives fixed values to variables 'tikTokHours', 'spotifyHours', 'messagingHours', instagramHours', and 'phoneBattery'.
Then it uses the switch case method to calculate and subtract the percentage usage from 'phoneBattery'. It displays the output on the console.*/

public class BatteryCalculator {
    public static void main(String[] args) {
        int tikTokHours = 2;
        int spotifyHours = 3;
        double messagingHours = 1.5F;
        double instagramHours = 0.5F;
        int phoneBattery = 100;

        switch (phoneBattery) {
            case 100:
                phoneBattery -= tikTokHours * 17;
                phoneBattery -= spotifyHours * 5;
                phoneBattery -= messagingHours * 8;
                phoneBattery -= instagramHours * 12;
                System.out.printf("The battery of my phone at the end of the day is %d%%. \n", phoneBattery);
                break;
            default:
                System.out.printf("The battery of my phone at the end of the day is %d%%. \n", phoneBattery);
        }
    }
}
