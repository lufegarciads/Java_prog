package Part_I;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] ags) {

        //Initial Prompts
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        Scanner input = new Scanner(System.in); //read keyboard input

        String operation = input.next().toLowerCase();

        switch (operation) {
            case "add":
                System.out.println("Enter two integers: ");
                if (input.hasNextInt()) {
                    int a = input.nextInt();
                    int b = input.nextInt();
                    System.out.println(a + b);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "subtract":
                System.out.println("Enter two integers: ");
                if (input.hasNextInt()) {
                    int c = input.nextInt();
                    int d = input.nextInt();
                    System.out.println(c - d);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "multiply":
                System.out.println("Enter two doubles: ");
                if (input.hasNextDouble()) {
                    double e = input.nextDouble();
                    double f = input.nextDouble();
                    System.out.printf("%.2f \n", e * f);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "divide":
                System.out.println("Enter two doubles: ");
                if (input.hasNextDouble()) {
                    double g = input.nextDouble();
                    double h = input.nextDouble();
                    if (h != 0) {
                    System.out.printf("%.2f \n", g / h);
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "alphabetize":
                System.out.println("Enter two words: ");

                if ((input.hasNextInt()) || (input.hasNextDouble())) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                else {
                    String i = input.next();
                    String j = input.next();
                    String iLower = i.toLowerCase();
                    String jLower = j.toLowerCase();

                    int result = iLower.compareTo(jLower);
                    if (result == 0) {
                        System.out.print("Chicken or Egg.");
                    }
                    else if (result < 0) {
                        System.out.println(i + " comes before " + j + " alphabetically.");
                    }
                    else {
                        System.out.println(j + " comes before " + i + " alphabetically.");
                    }
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}
