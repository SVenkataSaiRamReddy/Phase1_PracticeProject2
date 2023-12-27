// Custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionHandlingDemo {


    // Method that throws an exception using 'throws' and 'throw'
    public static void methodWithThrow() throws CustomException {
        // Explicitly throwing a CustomException using 'throw'
        throw new CustomException("CustomException thrown from methodWithThrow");
    }

    public static void main(String[] args) {


        try {
            // Calling methodWithThrow that explicitly throws CustomException
            methodWithThrow();
        } catch (CustomException e) {
            // Catching CustomException thrown by methodWithThrow
            System.out.println("Caught CustomException: " + e.getMessage());
        } finally {
            // Finally block executes regardless of whether an exception occurred or not
            System.out.println("Finally block executed.");
        }

        // Other code after exception handling
        System.out.println("Program continues after exception handling.");
    }
}
