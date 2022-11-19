package Labs.Lab9;
import java.util.Scanner;

/****************************************************************************
 * GolfGames
 *****************************************************************************************************************************************************************
 * Put in players names and their scores in a game of golf and output their scores, names, the winner, the average for the hole, and the players below the average
 *________________________________________________________________________________________________________________________________________________________________
 * Shashank Sinha
 * 03/30/2022
 * Course Number: 42984 and Section: C90
 ****************************************************************************/

public class GolfGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter names : ");
        String inputStringNames = sc.nextLine();

        System.out.print("Enter scores : ");
        String inputScoresString = sc.nextLine();

        String[] names = getNames(inputStringNames);
        int[][] scores = getScores(inputScoresString);
        String winner = findWinner(names, scores);

        System.out.print("Enter hole Number : ");
        int holeNumber = sc.nextInt();

        double avgForHole = findAvgForHole(scores, holeNumber);
        String[] playersBelowAvg = searchPlayersBelowAvg(names, scores, holeNumber, avgForHole);

        System.out.println("The winner is: " + winner);
        System.out.println("The average for Hole " + holeNumber + " is: " + avgForHole);
        System.out.print("The players below the average for Hole " + holeNumber + " are: ");

        for (int i = 0; i < playersBelowAvg.length; i++) {
            System.out.print(playersBelowAvg[i] + " ");
        }
    }
    /***************************************************************
     * Returns the string array of the inputted name string,
     * creating a new index for array that is divided by commas
     ***************************************************************/
    public static String[] getNames(String inputStringNames) {
        String names[] = inputStringNames.split(",");
        return names;
    }

    /****************************************************************************
     * Returns the 2D array for scores given the inputted score string, creating
     * a new row for the array at each "<>" and new index at each comma
     ****************************************************************************/

    public static int[][] getScores(String inputScoresString) {
        String[] scoresString = inputScoresString.split("<>");

        int holes = scoresString.length;
        int numberOfPlayers = scoresString[0].split(",").length;

        int[][] scores = new int[holes][numberOfPlayers];

        for (int i = 0; i <= holes - 1; i++) {
            int[] individualScores = new int[numberOfPlayers];
            String[] individualScoresString = scoresString[i].split(",");

            for (int j = 0; j < numberOfPlayers; j++) {
                individualScores[j] = Integer.parseInt(individualScoresString[j]);
            }
            scores[i] = individualScores;
        }

        return scores;

    }

    /****************************************************************************************
     *  Given the inputted int array of scores, it evaluates each row by looking at the length
     *  and seeing whether the previous score is greater or less than the current score in the
     *  array, from where once it reaches the end, it checks which name that score is
     *  corresponding with and returns that name.
     *****************************************************************************************/

    public static String findWinner(String[] names, int[][] scores) {
        int[] addedScores = new int[names.length];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                addedScores[j] += scores[i][j];
            }
        }

        int min = 0;
        for (int i = 0; i < addedScores.length; i++) {
            if (addedScores[i] < addedScores[min]) {
                min= i;
            }
        }

        return names[min];

    }

    /****************************************************************************************
     *  When the user enters the hole, it totals the scores for that hole number then divides
     *  the total by the length of that row.
     *****************************************************************************************/

    public static double findAvgForHole(int[][] scores, int holeNum) {
        double total = 0;
        for (int i = 0; i < scores[0].length; i++) {
            total += scores[holeNum - 1][i];
        }
        return total / scores[0].length;

    }

    /****************************************************************************************
     *  By searching the 2D array comparing each players' score on that row, the for loop will
     *  compare the players score to the average. The next for loop uses that to output the
     *  names that are below the average.
     *****************************************************************************************/

    public static String[] searchPlayersBelowAvg(String[] names, int[][] scores, int holeNum, double avgForHole) {

        int belowAvgPlayers = 0;
        for (int i = 0; i < names.length; i++) {
            if (scores[holeNum - 1][i] < avgForHole) {
                belowAvgPlayers++;
            }
        }

        String[] result = new String[belowAvgPlayers];
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (scores[holeNum - 1][i] < avgForHole) {
                result[index++] = names[i];
            }
        }
        return result;
    }
}



