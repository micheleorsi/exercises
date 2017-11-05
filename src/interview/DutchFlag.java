package interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DutchFlag {
    int[] temp = new int[]{1,2,3,1,2,2,3,3};

    void partition(int[] array) {
        int partition = 0;
        int max = array.length-1;
        for(int i=0; i<array.length; i++) {
            if(array[i]<2) {
                swap(array,partition, i);
                partition++;
            }
        }
        for(int i=partition; i<array.length; i++) {
            if(array[i]==2) {
                swap(array,partition, i);
                partition++;
            }
        }
    }

    @Test
    public void empty() {
        partition(new int[]{});
    }

    @Test
    public void first() {
        int[] array = new int[]{1, 2, 3, 1, 2, 2, 3, 3};
        partition(array);
        for(int i=1; i<array.length; i++) {
            if(array[i]<array[i-1]) {
                Assert.fail();
            }
        }
        System.out.println(Arrays.toString(array));

        array = new int[]{3, 3, 2, 3, 2, 2, 3, 1};
        partition(array);
        for(int i=1; i<array.length; i++) {
            if(array[i]<array[i-1]) {
                Assert.fail();
            }
        }
        System.out.println(Arrays.toString(array));

    }

    void swap(int[] array, int first,int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;

    }
}
