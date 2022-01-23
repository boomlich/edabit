/*
Solution for the following coding challenge:
https://edabit.com/challenge/42DtofyzmZXjWXCtw
 */

package DigitsBattle;

public class Main {
    public static void main(String[] args) {

        // Example 1
        System.out.println(battleOutcome(93552129));

        // Example 2
        System.out.println(battleOutcome(3245196));
    }

    public static int battleOutcome(int battleNumber) {
        // Convert int to array of digits
        char[] temp = String.valueOf(battleNumber).toCharArray();
        int[] battleNumArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            battleNumArray[i] = Character.getNumericValue(temp[i]);
        }

        // Check adjacent digits to find which is larges of the two
        String winners = "";
        for (int i = 0; i < battleNumArray.length-1; i += 2) {
            int numA = battleNumArray[i];
            int numB = battleNumArray[i+1];
            winners += compareNumbers(numA, numB);
            System.out.println(numA + " ::: " + numB);
        }

        // If odd length, add last digit
        if (temp.length % 2 == 1) {
            winners += battleNumArray[battleNumArray.length-1];
        }

        return Integer.parseInt(winners);
    }

    public static String compareNumbers(int a, int b){
        String result = "";

        if (a != b) {
            if (a > b) {
                result = String.valueOf(a);
            } else {
                result = String.valueOf(b);
            }
        }
        return result;
    }
}
