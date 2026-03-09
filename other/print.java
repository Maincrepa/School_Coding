import java.util.Scanner;

public class print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("The sum of the two is: " + (firstNumber + secondNumber));

        scanner.close();
    }
}