package algo.sort;

public class QuickSort implements Sort
{
    @Override
    public void sort(int[] array) {
        this.quick(array,0,array.length-1);
    }

    private void quick(int[] array, int left, int right)
    {
        if ( left < right )
        {
            int p = partition(array,left,right);
            quick(array,left,p-1);
            quick(array,p+1,right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int idx = left;  // Index of smaller element

        for (int j = left; j < right; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= array[right])
            {
                swap(array, idx, j);
                idx++;    // increment index of smaller element
            }
        }
        swap(array, idx, right);
        return idx;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
