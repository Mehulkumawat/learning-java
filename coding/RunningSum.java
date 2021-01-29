package coding;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] input = new int[] { 11 , 12 , 13, 14}; 
        
        int[] result = approach1(input);
        
        System.out.println(Arrays.toString(result));
        
    }

    public static int[] approach1(int[] input ) {
         
        int length = input.length;
        int[] result = new int[length];
		for(int i = 0 ; i <= length ; i++){
            int sum = 0;
            for(int j = 0; j <= i ; j++){
                sum = sum + input[j];
            }
            
			result[i] = sum ;
        }
        return result;
    }

    public int[] approach2(int[] input) {
        int length = input.length;
        int[] result = new int[length];
        int sum = 0; 
        for(int i = 0 ; i <= length ; i++){
            sum = sum + input[i];
            result[i] = sum;
        }
        return result;
    }
    

    
}
