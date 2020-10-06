import java.util.Scanner;


public class Myscanner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want? add or subtract?");
        String operation = scanner.nextLine().toLowerCase();
        
        if (operation.equals("add")) {
            // Adding here.

            addition(scanner);
            
        } else if (operation.equals("subtract")) {
            // Subtract here.
            subtraction(scanner);
        } else {
            // Not supported operation.
            System.out.println("Unsupported operation: " + operation);
        }
    }
    public static void addition(Scanner scanner) {
        System.out.println("Type first number to add: ");
            int a = Integer.valueOf(scanner.nextLine());
            
            System.out.println("Type second number to add: ");
            int b = Integer.valueOf(scanner.nextLine());
            
            System.out.println("Bro, your addition is: " + (a + b));
        
    }
    public static void subtraction(Scanner scanner) {
        System.out.println("Type first number to subtract: ");
            int a = Integer.valueOf(scanner.nextLine());
            
            System.out.println("Type second number to subtract: ");
            int b = Integer.valueOf(scanner.nextLine());
            
            System.out.println("Bro, your subtraction is: " + (a - b));
    }
    
}
