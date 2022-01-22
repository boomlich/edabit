/*
Solution for the following coding challenge:
https://edabit.com/challenge/g3zwGCJN5Ti8TSSbh
 */

package SimpleCircleCollisionDetection;

public class Main {
    public static void main(String[] args) {

        // Example 1
        int[] circleA = {10, 0, 0};
        int[] circleB = {10, 10, 10};
        System.out.println(isCircleCollision(circleA, circleB));

        // Example 2
        circleA = new int[]{1, 0, 0};
        circleB = new int[]{1, 10, 10};
        System.out.println(isCircleCollision(circleA, circleB));
    }

    public static boolean isCircleCollision(int[] circleA, int[] circleB){
        boolean circlesColliding = false;

        // Calculate distance from each circle's center and check
        // if that distance is smaller than the added radius's.
        double distanceAB = Math.sqrt(Math.pow(circleB[1] - circleA[1], 2) + Math.pow(circleB[2] - circleA[2],2));
        if (distanceAB < circleA[0] + circleB[0]) {
            circlesColliding = true;
        }

        return circlesColliding;
    }
}
