import java.util.*;

public class FactorialCalculator {
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        long result = factorial(num);
        System.out.println("Factorial of " + num + " is " + result);

        scanner.close();
    }
}
