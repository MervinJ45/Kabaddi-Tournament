package study.threads;

class NewThread1 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " New Thread");
                //checking whether the thread is interrupted
                //.interrupt set the interrupt flag of a thread to true
                if (Thread.interrupted()) {
                    //throws exception manually when the thread interruption flag is true
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}

public class ClassExtendsThread {
    public static void main(String[] args) {
        NewThread1 thread = new NewThread1();
        //start will make the created thread run
        thread.start();
        //cant control the order of execution of thread
        for (int i = 0; i < 5; i++) {
            thread.interrupt();
            System.out.println(i + " Main Thread");
        }
    }
}
