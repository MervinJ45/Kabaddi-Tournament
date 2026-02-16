package study.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        //creating virtual threads
        //Using try-with-resources on a virtual-thread
        //ExecutorService makes the main thread wait until all virtual-thread tasks complete.
        try (ExecutorService vt = Executors.newVirtualThreadPerTaskExecutor()) {
            vt.execute(() -> {
                for (int i = 0; i < 5; i++) {
                    if (i == 2) {
                        try {
                            //put the current thread to sleep
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (i == 3) {
                        //give time for other vts to execute
                        Thread.yield();
                    }
                    System.out.println("VT1 ");
                }
            });
            vt.execute(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("VT2 ");
                }
            });
            vt.shutdown();
        }
    }
}
