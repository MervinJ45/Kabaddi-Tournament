package study.threads;

class NewThread2 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " Slept New Thread");
            //should be surrounded by a exception handler
            try {
                //makes the thread execution waiting for specified milliseconds
                //will throw exception when the thread is interrupted by another thread
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class ClassImplementsRunnable {

    //JVM will create the main thread and starts executing it
    public static void main(String[] args) {
        Thread newThread = new Thread(new NewThread2());
        //starts executing the implemented thread and the newThread all three threads running concurrently
        newThread.start();
        //used lambda expression because runnable is a functional interface
        Runnable thread = () -> {
            for (int i = 0; i < 5; i++) {
                //interrupt will wake the thread up by showing exception when the thread is in sleep/wait/join
                //otherwise it sets the interrupt flag to true
                //interrupt won't kill the thread
                newThread.interrupt();
                System.out.println(i + " Thread");
            }
        };
        Thread implementedThread = new Thread(thread);
        implementedThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " Main Thread");
        }
    }
}
