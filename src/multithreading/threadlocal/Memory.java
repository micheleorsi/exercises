package multithreading.threadlocal;

public class Memory {

    private ThreadLocal<Coordinate> coord = new ThreadLocal<Coordinate>() {
        @Override
        synchronized protected Coordinate initialValue() {
            if(actual.r ==(rows)) {
                throw new RuntimeException("out of memory");
            } else if (actual.c == cols - 1) {
                actual.c = 0;
                actual.r++;
            } else {
                actual.c++;
            }
            return new Coordinate(actual.r, actual.c);
        }
    };

//            ThreadLocal.withInitial(
//            () -> {
//                synchronized(this) {
//                    if(actual.r ==(rows)) {
//                        throw new RuntimeException("out of memory");
//                    } else if(actual.c ==cols-1) {
//                        actual.c =0;
//                        actual.r++;
//                    } else {
//                        actual.c++;
//                    }
//                    return new Coordinate(actual.r,actual.c);
//                }
//            }
//    );

    static Coordinate actual;
    static int rows;
    static int cols;
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
        Coordinate local = coord.get();
        Thread.yield();
        this.write(local.r, local.c,value);
    }


}
