/*
Solution for the following coding challenge:
https://edabit.com/challenge/v96NThCRg5M5MLGfq
 */

package StalactitesOrStalagmites;

public class Main {
    public static void main(String[] args) {

        // Example 1: stalactites
        int[][] formationA = {
                {0, 1, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        System.out.println(mineralFormation(formationA));

        // Example 2: stalagmites
        int[][] formationB = {
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(mineralFormation(formationB));

        // Example 3: both
        int[][] formationC = {
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(mineralFormation(formationC));
    }

    public static String mineralFormation(int[][] inputArray){

        boolean stalactite = nonEmptyRow(inputArray[0]);
        boolean stalagmite = nonEmptyRow(inputArray[inputArray.length-1]);

        if (stalactite == stalagmite) {
            return "both";
        } else if (stalactite) {
            return "stalactites";
        } else {
            return "stalagmites";
        }
    }

    public static boolean nonEmptyRow(int[] row){
        for (int x: row) {
            if (x == 1) {
                return true;
            }
        }
        return false;
    }
}
