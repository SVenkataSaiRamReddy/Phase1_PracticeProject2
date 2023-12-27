public class TryCatchExample {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
            int numerator = 10;
            int denominator = 0;
            
            // Division by zero will throw an ArithmeticException
            int result = numerator / denominator;

            System.out.println("Result: " + result); // This line won't be executed
        } catch (ArithmeticException e) {
            // Catch block to handle the specific exception (ArithmeticException)
            System.out.println("An arithmetic exception occurred: " + e.getMessage());
        } catch (Exception e) {
            // Catch block to handle any other exception
            System.out.println("An exception occurred: " + e.getMessage());
        } finally {
            // Finally block will always execute, irrespective of whether an exception occurred or not
            System.out.println("Finally block executed.");
        }

        // This line will be executed after exception handling
        System.out.println("Program continues after exception handling.");
    }
}
