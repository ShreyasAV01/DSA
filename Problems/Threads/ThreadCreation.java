package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadCreation {

     static class SimpleThreadUsingThreadsClass extends Thread{
         @Override
         public void run() {
             System.out.println("SimpleThread is running");
         }
     }

     static class SimpleThreadUsingRunnable implements Runnable{
         @Override
         public void run() {
             System.out.println("SimpleThreadUsingRunnable thread is running");

         }
     }

     static class SimpleThreadUsingCallable implements Callable<Integer>{
         @Override
         public Integer call(){
             System.out.println("SimpleThreadUsingCallable thread is running "+ Thread.currentThread().getName());
             return 12;
         }
     }
    public static void main(String[] args) throws InterruptedException {
//      Using Threads Class
        SimpleThreadUsingThreadsClass thread1 = new SimpleThreadUsingThreadsClass();
        thread1.start();

//      Using the runnable interface
        SimpleThreadUsingRunnable simpleThread2 = new SimpleThreadUsingRunnable();
        Thread thread2 = new Thread(simpleThread2);
        thread2.start();

//      using the callable interface
        SimpleThreadUsingCallable simpleThreadUsingcallable = new SimpleThreadUsingCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(simpleThreadUsingcallable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();

//      using lambda expression
        Thread lambdaThread = new Thread(() -> System.out.println("Thread created using lambda"));
        lambdaThread.start();

//      Using the Executor service
        ExecutorService executorService = Executors.newFixedThreadPool(2) ;
        executorService.submit(() -> {System.out.println("task1 is running in Thread "+Thread.currentThread().getName());});
        executorService.submit(() -> {System.out.println("task2 is running in Thread "+Thread.currentThread().getName());});

        executorService.shutdown();

        Thread virtualThread = Thread.ofVirtual().name("MyVirtualThread").start(() -> System.out.println("Running in virtual thread: " + Thread.currentThread().getName()));
        virtualThread.join();
    }
}
