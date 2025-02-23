package Collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private final ConcurrentHashMap<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();

        Runnable task = () -> {
            for (int i=0; i<1000; i++ ){
                threadSafeCounter.increment("test");
            }
        };

        Thread t1= new Thread(task);
        Thread t2= new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter value : "+threadSafeCounter.getValue("test"));
    }

    public void increment(String key){
        counterMap.computeIfAbsent(key, k ->new AtomicInteger(0)).incrementAndGet();
    }
    public int getValue(String key){
        return counterMap.getOrDefault(key,new AtomicInteger(0)).get();
    }

    public void decrement(String key){
        counterMap.computeIfAbsent(key, k ->new AtomicInteger(0)).decrementAndGet();
    }

    public void reset(String key){
        counterMap.remove(key);
    }


}
