import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            // Try to perform division by zero to trigger an ArithmeticException
            int result = 100 / num;
            System.out.println("Result of 100 divided by " + num + " is: " + result);
        } catch (ArithmeticException e) {
            // Catch block for handling ArithmeticException
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (Exception e) {
            // Catch block for handling other exceptions
            System.out.println("Exception caught: " +e.getClass().getSimpleName());
        } finally {
            // Finally block executed regardless of whether an exception occurred or not
            System.out.println("Finally block executed.");
        }

        System.out.println("Program continues after exception handling.");
    }
}
