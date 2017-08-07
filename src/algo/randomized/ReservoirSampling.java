package algo.randomized;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {

    // A function to randomly select k items from stream[0..n-1].
    void selectKItems(int stream[], int n, int k)
    {
        int i;  // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int[] reservoir = new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        System.out.println("after "+k+": "+Arrays.toString(reservoir));

        // Iterate from the (k+1)th element to nth element
        while (i < n)
        {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i+1);

            // If the randomly  picked index is smaller than k, then replace
            // the element present at the index with new element from stream
            if (j < k)
                reservoir[j] = stream[i];

            System.out.println("random "+j+": "+Arrays.toString(reservoir));

            i++;
        }
        System.out.println("after "+i+": "+Arrays.toString(reservoir));
    }

    @Test
    public void test()
    {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        selectKItems(stream, stream.length, 5);
    }
}
