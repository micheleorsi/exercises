package algo.heap;

import org.junit.Test;

public class HeapInArray
{
    /**
     *                   1492
     *              /           \
     *          1783            1776
     *        /      \          /    \
     *     1804      1865     1945   1963
     *     /   \       /
     *  1918  2001   1941
     *
     */
    @Test
    public void test()
    {
        int[] toInsert = new int[]{
            1776,1865,1918,1804,1492,1945,1963,1783,2001,1941
        };
        Heap<Integer> pq = new Heap<>(10);
        for(int val:toInsert)
        {
            pq.insert(val);
        }
        int i=0;
        for(Object val : pq.S)
        {
            System.out.print(i++ +": ");
            System.out.println(val);
        }
    }
}

class Heap<E extends Comparable<E>> {

    Object S[];
    private int last;
    private int capacity;

    public Heap(int cap) {
        S = new Object[cap + 1];
        last = 0;
        capacity = cap;
    }

    public int size() {
        return last;
    }

    //
    // returns the number of elements in the heap
    //

    public boolean isEmpty() {
        return size() == 0;
    }

    //
    // is the heap empty?
    //

    public E min() throws HeapException {
        if (isEmpty())
            throw new HeapException("The heap is empty.");
        else
            return (E) S[1];
    }

    //
    // returns element with smallest key, without removal
    //

    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
    }

    public void insert(E e) throws HeapException {
        if (size() == capacity)
            throw new HeapException("Heap overflow.");
        else{
            last++;
            S[last] = e;
            upHeapBubble();
        }
    }

    // inserts e into the heap
    // throws exception if heap overflow
    //

    public E removeMin() throws HeapException {
        if (isEmpty())
            throw new HeapException("Heap is empty.");
        else {
            E min = min();
            S[1] = S[last];
            last--;
            downHeapBubble();
            return min;
        }
    }

    //
    // removes and returns smallest element of the heap
    // throws exception is heap is empty
    //

    /**
     * downHeapBubble() method is used after the removeMin() method to reorder the elements
     * in order to preserve the Heap properties
     */
    private void downHeapBubble(){
        int index = 1;
        while (true){
            int child = index*2;
            if (child > size())
                break;
            if (child + 1 <= size()){
                //if there are two children -> take the smalles or
                //if they are equal take the left one
                child = findMin(child, child + 1);
            }
            if (compare(S[index],S[child]) <= 0 )
                break;
            swap(index,child);
            index = child;
        }
    }

    /**
     * upHeapBubble() method is used after the insert(E e) method to reorder the elements
     * in order to preserve the Heap properties
     */
    private void upHeapBubble(){
        int index = size();
        while (index > 1){
            int parent = index / 2;
            if (compare(S[index], S[parent]) >= 0)
                //break if the parent is greater or equal to the current element
                break;
            swap(index,parent);
            index = parent;
        }
    }

    /**
     * Swaps two integers i and j
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Object temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

    /**
     * the method is used in the downHeapBubble() method
     * @param leftChild
     * @param rightChild
     * @return min of left and right child, if they are equal return the left
     */
    private int findMin(int leftChild, int rightChild) {
        if (compare(S[leftChild], S[rightChild]) <= 0)
            return leftChild;
        else
            return rightChild;
    }

    public String toString() {
        String s = "[";
        for (int i = 1; i <= size(); i++) {
            s += S[i];
            if (i != last)
                s += ",";
        }
        return s + "]";
    }
    //
    // outputs the entries in S in the order S[1] to S[last]
    // in same style as used in ArrayQueue
    //

}


class HeapException extends RuntimeException {
    public HeapException(){};
    public HeapException(String msg){super(msg);}
}
