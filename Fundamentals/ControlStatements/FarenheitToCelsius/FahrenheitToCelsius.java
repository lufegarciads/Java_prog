import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {

        //final int MAX_TEMP = 140;
        final int MIN_PARK_TEMP = 70;
        final int MAX_PARK_TEMP = 90;

        Scanner input = new Scanner(System.in); //read keyboard input
        System.out.print("Enter a Farenheit value: ");
        int farenheit = input.nextInt();


        System.out.print("Enter the Day of the Week: ");
        String day = input.next();

        double celsius = (5D/9D) * (farenheit - 32);

        boolean raining = false;
        System.out.print("Is it raining? (y/n): ");
        String rainInput = input.next().toLowerCase();
        if (rainInput.startsWith("y")) {
            raining = true;
        }

        System.out.println("Day of the Week: " + day);
        System.out.println("Farenheit: " + farenheit);
        System.out.println("Celsius: " + celsius);

        if ((farenheit >= MIN_PARK_TEMP) && (farenheit <= MAX_PARK_TEMP)) {
           System.out.println("Yay! It's at least " + MIN_PARK_TEMP + " but under " + MAX_PARK_TEMP);
            if (raining) {
                System.out.println("Look up for fun things to do in the rain");
            }
            else {
                System.out.println("Time to go to park");
            }
        }
        else {
            System.out.println("Bye");
        }
       input.close();
    }
}
