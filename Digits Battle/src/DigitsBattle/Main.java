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
        char[] digits = String.valueOf(battleNumber).toCharArray();

        // Check adjacent digits to find which is larges of the two
        String winners = "";
        for (int i = 0; i < digits.length-1; i += 2) {
            int numA = Character.getNumericValue(digits[i]);
            int numB = Character.getNumericValue(digits[i+1]);
            winners += compareNumbers(numA, numB);
        }

        // If odd length, add last digit
        if (digits.length % 2 == 1) {
            winners += String.valueOf(digits[digits.length-1]);
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
