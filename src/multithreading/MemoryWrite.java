package multithreading;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class MemoryWrite {

    public static class Memory {
        ThreadLocal<Integer> local;
        AtomicInteger idx;
        final int max;
        int[] mem;
//        int idx;

        public Memory(int max) {
            this.max = max;
            mem = new int[max];
//            idx=0;
            idx = new AtomicInteger(0);
            local = new ThreadLocal<>();
        }

        synchronized void write(int idx, int value) {
            mem[idx]=value;
//            System.out.println("idx: "+idx+" -> value: "+value);
        }

        void writeNext(int value) {
            int i = idx.getAndIncrement();
            Thread.yield();
            local.set(i);
            if(local.get()==max) {
                throw new RuntimeException("finished");
            } else {
                this.write(local.get(),value);
//                idx++;
            }
        }
    }

    public static class Client implements Runnable {

        final Memory write;

        public Client(Memory write) {
            this.write = write;
        }

        @Override
        public void run() {
            this.write.writeNext((int) (Math.random() * 100D+1));
        }
    }

    @Test
    public void test() throws InterruptedException {
        int max = 10000;
        Memory mw = new Memory(max);
        Thread[] t = new Thread[max];

        for (int i : mw.mem) {
            Assert.assertTrue(i==0);
        }

        for(int i=0; i<max; i++) {
            t[i]=new Thread(new Client(mw));
        }

        for (Thread thread : t) {
            thread.start();
        }

        for (Thread thread : t) {
            thread.join();
        }


        for (int i : mw.mem) {
            Assert.assertTrue(i+" == 0 ",i>0);
        }

    }

}
