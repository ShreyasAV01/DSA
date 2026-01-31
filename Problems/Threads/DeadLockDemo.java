package Threads;

public class DeadLockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("T1: Acquiring lock1");
            synchronized (lock1) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("T1: Wants lock2 → DEADLOCK!");
                synchronized (lock2) {
                    System.out.println("T1: Both locks");
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            System.out.println("T2: Acquiring lock2");
            synchronized (lock2) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("T2: Wants lock1 → DEADLOCK!");
                synchronized (lock1) {
                    System.out.println("T2: Both locks");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        // Keep main alive
        try { Thread.sleep(10000); } catch (InterruptedException e) {}
        System.out.println("Main: Check VisualVM now!");
    }
}

