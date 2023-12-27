class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running by extending Thread class");
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread running by implementing Runnable interface");
    }
}
public class ThreadsExample {
    public static void main(String[] args) {

        // 1. extending the 'Thread' class
        MyThread myThread = new MyThread();
        myThread.start();


        // 2. implementing the 'Runnable' interface
        Thread thread=new Thread(new MyRunnable());
        thread.start();


    }
}
