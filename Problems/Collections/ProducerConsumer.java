package Collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        Thread producer = new Thread(new Producer (queue));
        Thread consumer = new Thread(new Consumer (queue));
        producer.start();
        consumer.start();

    }

static class Producer implements Runnable{
private BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("produced: " + i);
                queue.put(i);
                Thread.sleep(1000);
            }
            queue.put(-1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


static class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();
                if (item == -1) {
                    System.out.println("No more items to consume. Exiting...");
                    break;  // Stop consuming if sentinel value is found
                }
                System.out.println("Consumed: "+item);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }

    }
}