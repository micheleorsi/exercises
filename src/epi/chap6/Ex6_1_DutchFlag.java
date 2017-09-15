package epi.chap6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Ex6_1_DutchFlag {

    @Test
    public void test() {
        int[] array = new int[]{10, 6, 2, 6, 4, 50, 2, 6, 12, 1};
        dutch(array,7);
        System.out.println(Arrays.toString(array));

        array = new int[]{10, 6, 2, 6, 4, 50, 2, 6, 12, 1};
        dutch2(array,7);
        System.out.println(Arrays.toString(array));

    }

    void dutch2(int[] array, int idx) {
        int pivot= array[idx];
        int smaller=0;
        int equal=0;
        int large=array.length-1;
        while(equal<=large) {
            if(array[equal]<pivot) {
                swap(array,smaller,equal);
                smaller++;
                equal++;
            } else if(array[equal]==pivot) {
                equal++;
            } else {
                swap(array,equal, large);
                large--;
            }
        }
    }

    void dutch(int[] array, int idx) {
        // check if array length > idx
        int pivot = array[idx];
        int partIdx = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i]<pivot) {
                swap(array, i, partIdx);
                partIdx++;
            }
        }
        for(int i=partIdx; i<array.length; i++) {
            if(array[i]==pivot) {
                swap(array, i, partIdx);
                partIdx++;
            }
        }

    }

    private void swap(int[] array, int i, int partIdx) {
        int temp = array[i];
        array[i]=array[partIdx];
        array[partIdx]=temp;
    }
}
