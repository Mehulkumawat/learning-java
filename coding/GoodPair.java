package coding;

// import java.util.Arrays;

public class GoodPair {
    public static void main(String[] args) {
        int result = pairFinder(new int[] {1,1,1,1});// o(1) and O(1)
        System.out.println(result);
    }

    public static int pairFinder(int[] nums) {// time complexity o(n^2) and space complexity o(1)
        int k = 0; // o(1) and O(1)
        int length = nums.length; // o(1) and O(1) 
        for(int i = 0; i < length; i++) {// o(n*j(n)), o(n^2) and O(1)
            for(int j = 0; j < length; j++) {// o(j) and O(1)
                if(nums[i] == nums[j] && i<j){
                    k++;// o(1) and O(1)
                }
            }
        }

        return k;
        
    }
    
}
