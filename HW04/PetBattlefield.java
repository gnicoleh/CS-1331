/**
 * PetBattlefield Class.
 * Class representing where Pet battles will occur.
 * Contains 2 private instance variables
 * Contains one 2-args constructor
 * Has a total of 9 methods: 3 public instance methods, 5 private helper, and the main method
 * @author gcanales6
 * @version 1.3
 */

public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;

    /**
     * 2-args constructor for a PetBattlefield object.
     * @param firstTeam Pet[] containing the different Pet objects in one team
     * @param secondTeam pet[] containing the different Pet objects in another team
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5 || secondTeam.length > 5) {
            this.firstTeam = new Pet[5];
            this.secondTeam = new Pet[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }

    @Override
    public String toString() {
        return String.format("First Team: %s vs Second Team: %s",
            PetBattlefield.getMembers(this.firstTeam), PetBattlefield.getMembers(this.secondTeam));
    }

    /**
     * compareTeams() instance method, estimates which team might win.
     */
    public void compareTeams() {
        int[] teamScores = new int[2];
        if (this.firstTeam.length <= this.secondTeam.length) {
            teamScores = PetBattlefield.compareSmallerTeamFirst(this.firstTeam, this.secondTeam);
        } else if (this.firstTeam.length > this.secondTeam.length) {
            teamScores = PetBattlefield.compareSmallerTeamFirst(this.secondTeam, this.firstTeam);
        }
        if (teamScores[0] - teamScores[1] > 0) {
            System.out.println("The first team will probably win.");
        } else if (teamScores[0] - teamScores[1] < 0) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * battle() instance method, controls the battle betwen Pet teams.
     */
    public void battle() {
        int[] petInCombat = new int[2];
        int i = 0;
        int j = 0;
        while (i < this.firstTeam.length && j < this.secondTeam.length) {
            if (this.firstTeam[i] == null || this.secondTeam[j] == null) {
                petInCombat = petIsNull(i, j);
                i = petInCombat[0];
                j = petInCombat[1];
            } else {
                petInCombat = petsBattling(i, j);
                i = petInCombat[0];
                j = petInCombat[1];
            }
        }
        isWinner();
    }

    /**
     * helper method, iterates through a team and creates a String with each Pet's stats.
     * @param team Pet[] containing the Pet object we want to iterate through
     * @return String representing the stats of the Pets in the Pet[]
     */
    private static String getMembers(Pet[] team) {
        String members = "";
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null && i < team.length - 1) {
                members += team[i].toString() + ", ";
            } else if (team[i] != null && i == team.length - 1) {
                members += team[i].toString();
            } else if (team[i] == null && i < team.length - 1) {
                members += "Empty, ";
            } else {
                members += "Empty";
            }
        }
        return members;
    }

    /**
     * helper method, compares Pet with its respective rival Pet according to their index.
     * @param smallerTeam Pet[] containing the different Pet objects in one team
     * @param largerTeam Pet[] containing the different Pet objects in another team
     * @return int[] containing the total points each team received when compared
     */
    private static int[] compareSmallerTeamFirst(Pet[] smallerTeam, Pet[] largerTeam) {
        int[] teamScores = new int[2];
        for (int i = 0; i < smallerTeam.length; i++) {
            if (smallerTeam[i] == null && largerTeam[i] == null) {
                teamScores[0]++;
                teamScores[1]++;
            } else if (smallerTeam[i] == null) {
                teamScores[1]++;
            } else if (largerTeam[i] == null) {
                teamScores[0]++;
            } else if (smallerTeam[i].compareTo(largerTeam[i]) > 0) {
                teamScores[0]++;
            } else if (smallerTeam[i].compareTo(largerTeam[i]) < 0) {
                teamScores[1]++;
            } else {
                teamScores[0]++;
                teamScores[1]++;
            }
        }
        for (int i = smallerTeam.length; i < largerTeam.length; i++) {
            if (largerTeam[i] != null) {
                teamScores[1]++;
            }
        }
        return teamScores;
    }

    /**
     * helper method, handles the battle between two null Pet objects.
     * @param i int describing the index of the first team's Pet
     * @param j int describing the index of the second team's Pet
     * @return int[] containing the index of each Pet[] to be used in the next round
     */
    private int[] petIsNull(int i, int j) {
        int[] petInCombat = new int[2];
        if (this.firstTeam[i] == null && this.secondTeam[j] == null) {
            i++;
            j++;
        } else if (this.firstTeam[i] == null) {
            i++;
        } else if (this.secondTeam[j] == null) {
            j++;
        }
        petInCombat[0] = i;
        petInCombat[1] = j;
        return petInCombat;
    }

    /**
     * helper method, maintains the battle between 2 Pets until at least one has fainted.
     * @param i int describing the index of the first team's Pet
     * @param j int describing the index of the second team's Pet
     * @return int[] containing the index of each Pet[] to be used in the next round
     */
    private int[] petsBattling(int i, int j) {
        int[] petInCombat = new int[2];
        boolean fight = true;
        while (fight) {
            this.firstTeam[i].attackPet(this.secondTeam[j]);
            this.secondTeam[j].attackPet(this.firstTeam[i]);
            if (this.firstTeam[i].hasFainted() && this.secondTeam[j].hasFainted()) {
                this.firstTeam[i] = null;
                i++;
                this.secondTeam[j] = null;
                j++;
                fight = false;
            } else if (this.firstTeam[i].hasFainted()) {
                this.firstTeam[i] = null;
                i++;
                fight = false;
            } else if (this.secondTeam[j].hasFainted()) {
                this.secondTeam[j] = null;
                j++;
                fight = false;
            }
        }
        petInCombat[0] = i;
        petInCombat[1] = j;
        return petInCombat;
    }

    /**
     * helper method, decides if there is a winner of if the match ended in a tie.
     */
    private void isWinner() {
        int winner = 999;
        int teamOneFaintedPets = 0;
        int teamTwoFaintedPets = 0;
        for (Pet p : this.firstTeam) {
            if (p == null || p.hasFainted()) {
                teamOneFaintedPets++;
            }
        }
        for (Pet p : this.secondTeam) {
            if (p == null || p.hasFainted()) {
                teamTwoFaintedPets++;
            }
        }
        if (teamOneFaintedPets == this.firstTeam.length && teamTwoFaintedPets == this.secondTeam.length) {
            winner = 0;
        } else if (teamOneFaintedPets == this.firstTeam.length) {
            winner = 2;
        } else if (teamTwoFaintedPets == this.secondTeam.length) {
            winner = 1;
        }
        switch (winner) {
        case 1:
            System.out.println("The first team won!");
            break;
        case 2:
            System.out.println("The second team won!");
            break;
        default:
            System.out.println("Both teams fainted.");
            break;
        }
    }

    /**
     * main method, contains the program to test all 5 classes.
     * @param args String[] representing the contents of the main method
     */
    public static void main(String[] args) {
        System.out.println("---------------- CREATING TEAM A [5 PETS TOTAL || NO NULLS] ---------------");
        // it doesn't matter if it's Pet turtle = new Turtle() || Turtle turtle = new Turtle(), turtle IS a Pet
        Pet turtleA1 = new Turtle(50, 5, false);
        Pet turtleA2 = new Turtle();
        Pet hippoA1 = new Hippo(50, 10, 7);
        Pet hippoA2 = new Hippo();
        Pet skunkA1 = new Skunk(50, 7, 3);
        Pet[] teamA = new Pet[]{turtleA1, hippoA1, skunkA1, hippoA2, turtleA2};
        for (Pet p : teamA) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("---------------- CREATING TEAM B [5 PETS TOTAL || NO NULLS] ---------------");
        Turtle turtlB1 = new Turtle(30, 7, true);
        Hippo hippoB1 = new Hippo(35, 25, 3);
        Hippo hippoB2 = new Hippo();
        Skunk skunkB1 = new Skunk(45, 5, 5);
        Skunk skunkB2 = new Skunk();
        Pet[] teamB = new Pet[]{hippoB2, skunkB2, hippoB1, turtlB1, skunkB1};
        for (Pet p : teamB) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("---------------- CREATING TEAM C [6 PETS TOTAL || NO NULLS] ---------------");
        Turtle turtlC1 = new Turtle(25, 10, true);
        Turtle turtleC2 = new Turtle();
        Hippo hippoC1 = new Hippo(15, 30, 10);
        Hippo hippoC2 = new Hippo();
        Skunk skunkC1 = new Skunk(20, 10, 7);
        Skunk skunkC2 = new Skunk();
        Pet[] teamC = new Pet[]{skunkC2, skunkC1, hippoC2, hippoC1, turtleC2, turtlC1};
        for (Pet p : teamC) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("---------------- CREATING TEAM D [5 PETS TOTAL || 2 NULLS] ---------------");
        Turtle turtlD1 = new Turtle(30, 10, true);
        Turtle turtleD2 = null;
        Hippo hippoD1 = new Hippo(25, 30, 10);
        Hippo hippoD2 = null;
        Skunk skunkD1 = new Skunk(20, 10, 7);
        Pet[] teamD = new Pet[]{turtleD2, skunkD1, hippoD1, hippoD2, turtlD1};
        for (Pet p : teamD) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("---------------- CREATING TEAM E [3 PETS TOTAL || NO NULLS] ---------------");
        Turtle turtlE1 = new Turtle(50, 7, true);
        Hippo hippoE1 = new Hippo(60, 10, 5);
        Skunk skunkE1 = new Skunk(70, 15, 5);
        Pet[] teamE = new Pet[]{skunkE1, hippoE1, turtlE1};
        for (Pet p : teamE) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }
        System.out.println("---------------- COMPARING TEAM A WITH TEAM B ---------------");
        PetBattlefield aVsB = new PetBattlefield(teamA, teamB);
        aVsB.compareTeams();
        System.out.println("---------------- COMPARING TEAM A WITH TEAM C ---------------");
        PetBattlefield aVsC = new PetBattlefield(teamA, teamC);
        aVsC.compareTeams();
        System.out.println("---------------- COMPARING TEAM A WITH TEAM D ---------------");
        PetBattlefield aVsD = new PetBattlefield(teamA, teamD);
        aVsD.compareTeams();
        System.out.println("---------------- COMPARING TEAM A WITH TEAM E ---------------");
        PetBattlefield aVsE = new PetBattlefield(teamA, teamE);
        aVsE.compareTeams();
        System.out.println("---------------- COMPARING TEAM B WITH TEAM C ---------------");
        PetBattlefield bVsC = new PetBattlefield(teamB, teamC);
        bVsC.compareTeams();
        System.out.println("---------------- COMPARING TEAM B WITH TEAM D ---------------");
        PetBattlefield bVsD = new PetBattlefield(teamB, teamD);
        bVsD.compareTeams();
        System.out.println("---------------- COMPARING TEAM B WITH TEAM E ---------------");
        PetBattlefield bVsE = new PetBattlefield(teamB, teamE);
        bVsE.compareTeams();
        System.out.println("---------------- COMPARING TEAM C WITH TEAM D ---------------");
        PetBattlefield cVsD = new PetBattlefield(teamC, teamD);
        cVsD.compareTeams();
        System.out.println("---------------- COMPARING TEAM C WITH TEAM E ---------------");
        PetBattlefield cVsE = new PetBattlefield(teamC, teamE);
        cVsE.compareTeams();
        System.out.println("---------------- COMPARING TEAM D WITH TEAM E ---------------");
        PetBattlefield dVsE = new PetBattlefield(teamD, teamE);
        dVsE.compareTeams();
        System.out.println("-----------------------------------------------------");
        System.out.println("---------------- BATTLES TAKING PLACE ---------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("------------------ TEAM A VS TEAM B -----------------");
        System.out.println(aVsB.toString());
        aVsB.battle();
        System.out.println(aVsB.toString());
        System.out.println("------------------ TEAM A VS TEAM C -----------------");
        System.out.println(aVsC.toString());
        aVsC.battle();
        System.out.println(aVsC.toString());
        System.out.println("------------------ TEAM D VS TEAM E -----------------");
        System.out.println(dVsE.toString());
        dVsE.battle();
        System.out.println(dVsE.toString());
    }
}
