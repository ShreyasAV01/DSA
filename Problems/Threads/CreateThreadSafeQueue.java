package Threads;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CreateThreadSafeQueue {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> threadSafeQueue = new ConcurrentLinkedQueue<>();

        // Adding elements to the queue
        threadSafeQueue.add("Element 1");
        threadSafeQueue.add("Element 2");
        threadSafeQueue.add("Element 3");
        threadSafeQueue.add("Element 4");


        // Removing elements from the queue
        threadSafeQueue.poll();
        System.out.println(" elements in the queue: " + threadSafeQueue);

        // Accessing the queue safely from multiple threads
        Runnable producer = () -> {
            for (int i=0; i<10;i++){
                threadSafeQueue.add( "new Element "+i);
                System.out.println("Added New Element " + i);
            }
        };

        Runnable consumer = () -> {
            while (!threadSafeQueue.isEmpty()){
                String item = threadSafeQueue.poll();
                System.out.println("Polled Element " + item);
            }
        };


        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        // Printing the remaining elements in the queue
        System.out.println("Remaining elements in the queue: " + threadSafeQueue);
    }
}
