package study.threads;

public class ThreadCounters {
    private int c;

    ThreadCounters() {
        c = 0;
    }

    //made the counter thread safe using synchronized keyword
    //synchronized will make sure only one thread can access a specific block or method at a timw
    public synchronized void increment() {
        c += 2;
        //will notify all the threads in waiting state to check the condition again
        notify();
    }

    public synchronized void decrement() throws InterruptedException {
        while (c == 0) {
            //will make the current thread wait if the condition satisfies
            wait();
        }
        c--;
    }

    public synchronized void displayC() {
        System.out.println(c);
    }
}

class main {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounters threadCounters = new ThreadCounters();
        Thread thread1 = new Thread(() -> {
            threadCounters.increment();
        });
        Thread thread2 = new Thread(() -> {
            threadCounters.increment();
        });
        Thread thread3 = new Thread(() -> {
            try {
                threadCounters.decrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                threadCounters.decrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        //used join to make sure
        threadCounters.displayC();

    }
}
