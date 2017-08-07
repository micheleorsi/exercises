package algo.sort;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSort implements Sort
{
    @Override
    public void sort(int[] array) {
        this.mergesort(array, 0, array.length-1);
    }

    // Main function that sorts arr[l..r] using mergesort()
    private void mergesort(int arr[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int middle = (left+right)/2;

            // Sort first and second halves
            mergesort(arr, left, middle);
            mergesort(arr , middle+1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    private void merge(int arr[], int left, int middle, int right)
    {
        Queue<Integer> lQueue = new LinkedList<>();
        Queue<Integer> rQueue = new LinkedList<>();

        for (int i = left; i<= middle; i++) // O(n)
            lQueue.add(arr[i]);
        for (int j = middle+1; j<= right; j++) // O(n)
            rQueue.add(arr[j]);

        int i = left;

        while(!(lQueue.isEmpty() || rQueue.isEmpty())) // O(n)
        {
            if(lQueue.peek() <= rQueue.peek())
            {
                arr[i++]=lQueue.poll();
            }
            else
            {
                arr[i++]=rQueue.poll();
            }
        }

        while(!lQueue.isEmpty()) arr[i++]= lQueue.poll(); // O(n)
        while(!rQueue.isEmpty()) arr[i++]= rQueue.poll(); // O(n)
    }

}
