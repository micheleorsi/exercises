package crackingcode.chapter10_sortingAndSearching;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedArray {

    @Test
    public void test() {
        int[] arr1 = new int[] {4,5,6,7,8,9,1,2,3};

        Assert.assertEquals(0,search(arr1,4));
        Assert.assertEquals(1,search(arr1,5));
        Assert.assertEquals(2,search(arr1,6));
        Assert.assertEquals(3,search(arr1,7));
        Assert.assertEquals(4,search(arr1,8));
        Assert.assertEquals(5,search(arr1,9));
        Assert.assertEquals(6,search(arr1,1));
        Assert.assertEquals(7,search(arr1,2));
        Assert.assertEquals(8,search(arr1,3));
        Assert.assertEquals(-1,search(arr1,13));
    }

    private int search(int[] array, int n) {
        return recursive(array,0,array.length-1, n);
    }

    int recursive(int[] array, int l, int r, int n) {
        if(l<=r) {
            int middle=(l+r)/2;
            if(n==array[middle]) {
                return middle;
            } else if(array[l]<array[middle]) { // left is normally ordered
                if(n>=array[l] && n<array[middle]) {
                    return recursive(array,l,middle-1,n); // search left
                } else {
                    return recursive(array,middle+1,r,n); // search right
                }
            } else if(array[r]>array[middle]) { // right is normally ordered
                if(n<=array[r] && n>array[middle]) {
                    return recursive(array,middle+1,r,n); // search right
                } else {
                    return recursive(array,l,middle-1,n); // search left
                }
            }
        }
        return -1;
    }
}
