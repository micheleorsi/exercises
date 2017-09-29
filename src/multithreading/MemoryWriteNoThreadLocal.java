package multithreading;

import org.junit.Assert;
import org.junit.Test;

public class MemoryWriteNoThreadLocal {

    class Coordinate {
        int r;
        int c;

        public Coordinate(int rIdx, int cIdx) {
            this.r = rIdx;
            this.c = cIdx;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    class Memory {
        Coordinate actual;
        final int rows;
        final int cols;
        int[][] mem;

        public Memory(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            mem = new int[rows][cols];
            actual = new Coordinate(0,-1);
        }

        synchronized void write(int iRow,int iCol, int value) {
            mem[iRow][iCol]=value;
        }

        void writeNext(int value) {
            Coordinate local = this.getActualCoordinate();
            Thread.yield();
            this.write(local.r, local.c,value);
        }

        synchronized Coordinate getActualCoordinate() {
            if(actual.r ==(rows)) {
                throw new RuntimeException("out of memory");
            } else if(actual.c ==cols-1) {
                actual.c =0;
                actual.r++;
            } else {
                actual.c++;
            }
            return new Coordinate(actual.r,actual.c);
        }
    }

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
