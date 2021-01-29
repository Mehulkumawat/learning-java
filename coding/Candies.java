package coding;

import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        // int[] childrenWithCandies = new int[] {5, 6, 7, 8};
        boolean[] result = candyDivider(3, new int[] { 5, 6, 7, 8 });
        System.out.println(Arrays.toString(result));
    }

    public static boolean[] candyDivider(int extracandies, int[] childrenWithCandies) {
        int length = childrenWithCandies.length;
        boolean[] result = new boolean[length];

        // Finding the max candies
        int maxCandies = childrenWithCandies[0];
        for (int j = 0; j < length; j++) {
            if (childrenWithCandies[j] > maxCandies) {
                maxCandies = childrenWithCandies[j];
            }
        }

        // Checking for each candidates if it can reach the max candies
        for (int i = 0; i < length; i++) {
            int canHaveCandies = childrenWithCandies[i] + extracandies;
            result[i] = maxCandies - canHaveCandies <= 0;
        }

        return result;
    }

}
