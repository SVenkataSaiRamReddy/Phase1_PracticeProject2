public class SleepAndWaitDemo {

    public static void main(String[] args) {
        SleepAndWaitDemo demo = new SleepAndWaitDemo();

        // Demonstrating sleep() method
        demo.sleepExample();

        // Demonstrating wait() method
        demo.waitExample();
    }

    // Example of sleep() method
    public void sleepExample() {
        System.out.println("Sleep Example:");

        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Count: " + i);
                // Sleep for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Sleep Example completed.\n");
    }

    // Example of wait() method
    public void waitExample() {
        System.out.println("Wait Example:");

        Object monitor = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (monitor) {
                try {
                    System.out.println("Waiting for a signal...");
                    // Waiting for another thread to call notify() or notifyAll()
                    monitor.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Received a signal and continuing execution.");
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Sending a signal...");
                // Sending a signal to wake up the waitingThread
                monitor.notify();
            }
        });

        waitingThread.start();
        notifyingThread.start();

        try {
            // Waiting for threads to complete
            waitingThread.join();
            notifyingThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Wait Example completed.");
    }
}
