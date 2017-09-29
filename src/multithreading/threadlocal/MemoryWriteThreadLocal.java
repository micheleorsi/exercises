package multithreading.threadlocal;

import org.junit.Assert;
import org.junit.Test;


public class MemoryWriteThreadLocal {

    class Client implements Runnable {

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
        int ROW = 500;
        int COL = 100;
        Memory mw = new Memory(ROW,COL);
        Thread[] t = new Thread[ROW*COL];

        for(int i=0; i<mw.mem.length; i++ ){
            int[] row = mw.mem[i];
            for(int j=0; j<row.length; j++) {
                int elem = mw.mem[i][j];
                Assert.assertTrue(elem+" != 0 ",elem==0);
            }
        }

        for(int i=0; i<ROW*COL; i++) {
            t[i]=new Thread(new Client(mw));
        }

        for (Thread thread : t) {
            thread.start();
        }

        for (Thread thread : t) {
            thread.join();
        }


        for(int i=0; i<mw.mem.length; i++ ){
            int[] row = mw.mem[i];
            for(int j=0; j<row.length; j++) {
                int elem = mw.mem[i][j];
                Assert.assertTrue(elem+" <= 0 ",elem>0);
            }
        }

    }

}
