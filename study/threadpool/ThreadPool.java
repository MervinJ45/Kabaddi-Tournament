package study.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //creating a threadpool with fixed no of threads
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //only 2 tasks can run parallel others wait in queue
        //tasks are queued in the order of .execute()
        //execute (Runnable)
        pool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1 " + Thread.currentThread().getName());
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 " + Thread.currentThread().getName());
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 3 " + Thread.currentThread().getName());
            }
        });
        pool.shutdown();

        //submit (Runnable & Callable)
        //Returns Future<>,can wait for completion, can get return value
        //Can catch exceptions via future.get() and cancel the task
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Future<?> f1 = fixedThreadPool.submit(() -> System.out.println("Task-1 " + Thread.currentThread().getName()));
        //wait for the next line of execution
        f1.get();
        Future<Integer> f2 = fixedThreadPool.submit(() ->{
            System.out.println("Task-2 " + Thread.currentThread().getName());
            return 1;
        });
        //get the return value
        System.out.println(f2.get());
        Future<Integer> f3 = fixedThreadPool.submit(() ->{
            System.out.println("Task-3 " + Thread.currentThread().getName());
            return 2;
        });
        fixedThreadPool.shutdown();

        //thread pool with a single thread the task are assigned only the thread
        //runs sequentially but not by the main thread
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        singleThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Single Thread Executor Task-1");
            }
        });
        singleThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Single Thread Executor Task-2");
            }
        });
        singleThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Single Thread Executor Task-3");
            }
        });
        singleThreadPool.shutdown();

        //cached threaded creates threads based on the tasks executed to the pool (no of threads cant be predicted)
        //it terminates the thread if it is idle for 60 seconds (grow and shrink automatically)
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cached Thread Pool Task-1 " + Thread.currentThread().getName());
            }
        });
        cachedThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cached Thread Pool Task-2 " + Thread.currentThread().getName());
            }
        });
        cachedThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cached Thread Pool Task-3 " + Thread.currentThread().getName());
            }
        });
        cachedThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cached Thread Pool Task-4 " + Thread.currentThread().getName());
            }
        });
        cachedThreadPool.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cached Thread Pool Task-5 " + Thread.currentThread().getName());
            }
        });
        cachedThreadPool.shutdown();
    }
}
