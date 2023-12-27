class SynchronizedCounter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    // Synchronized block
    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        // Creating an instance of SynchronizedCounter
        SynchronizedCounter counter = new SynchronizedCounter();

        // Creating multiple threads to access and modify the shared counter
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.decrement();
            }
        });

        // Starting threads
        incrementThread.start();
        decrementThread.start();

        try {
            // Waiting for threads to complete
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Displaying the final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
