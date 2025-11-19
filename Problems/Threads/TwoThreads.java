package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreads
{
private AtomicInteger sharedValue;

    public static void main(String[] args) {
//        Thread T1 = new Thread(this::increment);
//        Thread T2 = new Thread(this::increment);
    }

    private void increment(){
        for (int i=0; i<1000; i++){
            synchronized (this){
//                sharedValue++;
            }
        }
    }
}
