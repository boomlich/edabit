/*
Solution for the following coding challenge:
https://edabit.com/challenge/A8xQZTqzkn88cLCmj
 */

package ChessPieces;

public class Main {

    public static final String horizontal = "ABCDEFGH";

    public static void main(String[] args) {

        // Example moves
        printMove("Rook", "A8", "H8");
        printMove("Bishop", "A7", "G1");
        printMove("Queen", "C4", "D6");
        printMove("King", "D3", "E4");
        printMove("Knight", "D4", "E6");
        printMove("Knight", "D4", "F6");
        printMove("Pawn", "B2", "B4");
        printMove("Pawn", "D5", "D6");
        printMove("Pawn", "A2", "G6");
    }

    public static void printMove(String piece, String current, String target) {
        System.out.println(piece + " moves from " + current + " to " + target + " -> " + canMove(piece, current, target));
        System.out.println();
    }

    public static boolean canMove(String piece, String current, String target){

        char[] currentPos = current.toCharArray();
        char[] targetPos = target.toCharArray();

        switch (piece) {
            case "Rook":
                return movesStraight(currentPos, targetPos);
            case "Bishop":
                return movesDiagonally(currentPos, targetPos);
            case "Queen":
                return movesStraightOrDiagonally(currentPos, targetPos);
            case "King":
                if (movesStraightOrDiagonally(currentPos, targetPos)) {
                    int[] movement = movementDiff(currentPos, targetPos);
                    return movement[0] == 1 || movement[1] == 1;
                }
                break;
            case "Knight": {
                int[] movement = movementDiff(currentPos, targetPos);
                if (movement[0] == 1 && movement[1] == 2) {
                    return true;
                } else return movement[0] == 2 && movement[1] == 1;
            }
            case "Pawn": {
                int[] movement = movementDiff(currentPos, targetPos);
                if (movesStraight(currentPos, targetPos) && movement[0] == 0) {
                    return (currentPos[1] == '2' && movement[1] <= 2) || movement[1] == 1;
                }
                break;
            }
        }
        return false;
    }

    // Checks if piece moves straight
    public static boolean movesStraight(char[] currentPos, char[] targetPos) {
        return currentPos[0] == targetPos[0] || currentPos[1] == targetPos[1];
    }

    // Get horizontal and vertical movement
    public static int[] movementDiff(char[] currentPos, char[] targetPos) {
        int horizontalDiff = Math.abs(horizontal.indexOf(targetPos[0]) - horizontal.indexOf(currentPos[0]));
        int verticalDiff = Math.abs(Character.getNumericValue(targetPos[1]) - Character.getNumericValue(currentPos[1]));
        return new int[]{horizontalDiff, verticalDiff};
    }

    // Checks if piece moves diagonally
    public static boolean movesDiagonally(char[] currentPos, char[] targetPos) {
        int[] movement = movementDiff(currentPos, targetPos);
        return movement[0] == movement[1];
    }

    // Check if piece moves either in a straight or diagonal line
    public static boolean movesStraightOrDiagonally(char[] currentPos, char[] targetPos) {
        if (movesStraight(currentPos, targetPos)) {
            return true;
        } else return movesDiagonally(currentPos, targetPos);
    }
}
