import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        double result = 0;
        boolean valid = true;

        switch (operator) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b != 0) result = a / b;
                else {
                    System.out.println("Division by zero error.");
                    valid = false;
                }
                break;
            default:
                System.out.println("Invalid operator.");
                valid = false;
        }

        if (valid) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
