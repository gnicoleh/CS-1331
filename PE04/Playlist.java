/*
Course: CS 1331 - Intro to Object Oriented Programming
Student: Guisella Hernandez
Assignment: PE04
Date Submitted: 02/10/2022
Date Due: 02/14/2022
__________________________________________________________________________

This programs consists of 3 public static methods and the main method.
-The main method
 Initializes genres[], a length 7 array holding all the possible genre types available.
 Initializes playlist1[], a 7 length array containing a random selection of genres from genre[].
     These genres where manually selected.
 Initializes playlist2[], same as playlist1[], but with different genre types in it.
 Initializes the Scanner object, scan.
 Calls the other 3 methods.

-The addPlaylistInfo method takes in a Scanner object as a parameter and returns nothing.
 It uses user input to create and name a playlist with the given number of songs.
 The information provided is hen displayed on the console.

-The genreTally method takes in 2 String[] as parameters and returns an int[].
 It commpares the genres of the playlist created with the all the possible types of genres.
 Keeps tally of how many of each genre are in the playlist created. Assigns the total to
 totalTally[] of same length as genres[], which is returned by the method.

-The playlistScore method takes in 3 String[] as parameters and returns nothing.
 It calculates the popularity of each playlist array by taking the sum of each
 element within the array and multiplying it by its index. The resulting score of each playlist
 is saved in variables totalScore1 and totalScore2.
*/

import java.util.Scanner;

public class Playlist {

    // main method
    public static void main(String[] args) {
        String[] genres = {"Rap", "Pop", "Classical", "Hip Hop", "Rock", "Lo Fi"};
        String[] playlist1 = {"Rap", "Pop", "Classical", "Pop", "Hip Hop", "Classical", "Rock"};
        String[] playlist2 = {"Pop", "Classical", "Rock", "Lo Fi", "Pop", "Lo Fi", "Rock"};
        Scanner scan = new Scanner(System.in);
        addPlaylistInfo(scan);
        addPlaylistInfo(scan);
        genreTally(playlist1, genres);
        genreTally(playlist2, genres);
        playlistScores(playlist1, playlist2, genres);
    }

    // addPlaylistInfo method || void
    public static void addPlaylistInfo(Scanner input) {
        System.out.print("Enter number of songs in playlist: ");
        int numSongs = input.nextInt();
        input.nextLine(); // makes Java read the new line character given when entering numSongs
        System.out.print("Enter a playlist name: ");
        String playlistName = input.nextLine();
        System.out.printf("Playlist created successfully. Here are the details:\n"
            + "Number of Songs: %s%n" + "Name: %s%n", numSongs, playlistName);
    }

    // genreTally || int[]
    public static int[] genreTally(String[] genreArray, String[] genres) {
        System.out.println("The following types of genres are in your playlist: ");
        int[] totalTally = new int[genres.length];
        int count = 0;
        //for ()
        for (String i : genres) {
            int tally = 0;
            for (String j : genreArray) {
                if (j.equals(i)) {
                    tally++;
                }
            }
            totalTally[count] = tally;
            System.out.println(i + " " + totalTally[count]);
            count++;
        }
        return totalTally;
    }

    // playlistScores method || void
    public static void playlistScores(String[] playlist1, String[] playlist2, String[] genres) {
        int score1 = 0;
        int score2 = 0;
        int totalScore1 = 0;
        int totalScore2 = 0;
        int[] tallyArray1 = genreTally(playlist1, genres);
        int[] tallyArray2 = genreTally(playlist2, genres);
        for (int i = 0; i < genres.length; i++) {
            score1 = tallyArray1[i] * i;
            totalScore1 += score1;
            score2 = tallyArray2[i] * i;
            totalScore2 += score2;
        }
        if (totalScore1 > totalScore2) {
            System.out.println("The first playlist is likely to have more listeners than the second.");
        } else if (totalScore1 < totalScore2) {
            System.out.println("The second playlist is likely to have more listeners than the first.");
        } else {
            System.out.println("The two playlists are predicted to perform equally well.");
        }
    }
}
