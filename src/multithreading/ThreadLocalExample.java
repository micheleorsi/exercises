package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        static AtomicInteger value = new AtomicInteger(0);

        private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(
                () -> value.getAndIncrement()
        );

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        Thread thread3 = new Thread(sharedRunnableInstance);
        Thread thread4 = new Thread(sharedRunnableInstance);
        Thread thread5 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
            thread3.join(); //wait for thread 2 to terminate
            thread4.join(); //wait for thread 2 to terminate
            thread5.join(); //wait for thread 2 to terminate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
