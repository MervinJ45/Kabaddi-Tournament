package study.threads;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Runnable createdThread = () -> {
            //interrupt the thread that is waiting for the other thread to complete execution
            mainThread.interrupt();
            for (int i = 0; i < 5; i++) {
                System.out.println("Created Thread");
            }
        };
        Thread thread = new Thread(createdThread);
        thread.start();
        System.out.println("Main Thread");
        try {
            //.join() make the current thread to wait for the other thread to completes its exception
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
            return;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}