package coding;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] result = shuffleTheArray(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }); // const O(1)
        System.out.println(Arrays.toString(result));

    }

    public static int[] shuffleTheArray(int[] nums) {
        int length = nums.length; // const 1
        int n = length / 2; // const O(1)
        int[] result = new int[length]; // const O(n)
        
        // Handling even case
        int j = 0;
        for(int i = 0 ; i < length; i = i + 2) { //O(n) 1
            result[i] = nums[j++];//O(1) 
        }

        // Handling odd case
        int k = n; // const O(1)
        for(int i = 1; i < length; i = i + 2) { //O(n)
            result[i] = nums[k++];//O(1)
        }

        // for (int i = 0; i < length; i++) {

        //     if (i % 2 == 0) {
        //         result[i] = nums[i - k];
        //         k++;
        //     } else {
        //         result[i] = nums[i + n - j];
        //         j++;
        //     }
        // }

        return result;

    }

    

}
