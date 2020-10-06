import java.util.Scanner;

public class string{
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Type the first number to add:");
        int a = Integer.valueOf(scanner.nextLine());
        //waits for input
        
        System.out.println("Type the second number to add:");
        int b = Integer.valueOf(scanner.nextLine());
        
        int sum = a + b;
        String message = "Addition is " + sum + ". Bye!"; // String conc
        System.out.println(message);
 
}
    
}
