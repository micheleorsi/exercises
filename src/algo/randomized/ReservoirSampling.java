package algo.randomized;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * randomly choosing a sample of k items from a list S containing n items, where n is either a very large or unknown number.
 * Typically n is large enough that the list doesn't fit into main memory
 */
public class ReservoirSampling {

    // A function to randomly select k items from stream[0..n-1].
    void selectKItems(int stream[], int n, int k)
    {
        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int[] reservoir = new int[k];
        for (int i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        System.out.println("after "+k+": "+Arrays.toString(reservoir));

        for(int j=k ; j<n; j++)
        {
            int p = r.nextInt(j+1);

            if(p<k)
                reservoir[p] = stream[j];

            System.out.println("random "+j+": "+Arrays.toString(reservoir));


        }

        System.out.println("after "+n+": "+Arrays.toString(reservoir));
    }

    @Test
    public void test()
    {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        selectKItems(stream, stream.length, 5);
    }
}
