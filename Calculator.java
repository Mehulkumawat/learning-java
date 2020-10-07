import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int a, b;
        Scanner reader = new Scanner(System.in);
        System.out.println("enter two numbers");
        a = Integer.valueOf(reader.nextLine());
        b = Integer.valueOf(reader.nextLine());
        System.out.println("select an operator + - * /");
        String operator = reader.nextLine().toLowerCase();
        if(operator.equals("+")){
            System.out.println("your ans is " + (a+b));
        }
        else if (operator.equals("-")){
            System.out.println("your ans is " + (a-b));
        }
        else if (operator.equals("*")){
            System.out.println("your ans is " + (a*b));
        }
        else if (operator.equals("/")){
            System.out.println("your ans is " + (a/b));
        }
    }

    
}
