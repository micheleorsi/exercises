package multithreading.threadlocal;

public class Coordinate {

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
